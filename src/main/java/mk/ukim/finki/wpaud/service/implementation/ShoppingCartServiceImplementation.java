package mk.ukim.finki.wpaud.service.implementation;

import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.ShoppingCart;
import mk.ukim.finki.wpaud.model.User;
import mk.ukim.finki.wpaud.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.wpaud.model.exceptions.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.wpaud.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpaud.model.exceptions.ShoppingCartNotFoundException;
import mk.ukim.finki.wpaud.model.exceptions.UserNotFoundException;
import mk.ukim.finki.wpaud.repository.InMemoryShoppingCartRepository;
import mk.ukim.finki.wpaud.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaud.service.ProductService;
import mk.ukim.finki.wpaud.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService {

    private final InMemoryShoppingCartRepository shoppingCartRepository;
    private final InMemoryUserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImplementation(InMemoryShoppingCartRepository shoppingCartRepository,
                                             InMemoryUserRepository userRepository,
                                             ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long shoppingCartId) {
        if (!this.shoppingCartRepository.findById(shoppingCartId).isPresent()) {
            throw new ShoppingCartNotFoundException(shoppingCartId);
        }
        return this.shoppingCartRepository.findById(shoppingCartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.shoppingCartRepository.findByUsernameAndStatus(username, ShoppingCartStatus.CREATED).orElseGet(() -> {
            User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
            ShoppingCart shoppingCart = new ShoppingCart(user);
            return this.shoppingCartRepository.save(shoppingCart);
        });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        if (!shoppingCart.getProducts()
                .stream().filter(i -> i.getId().equals(productId))
                .collect(Collectors.toList()).isEmpty()) {
            throw new ProductAlreadyInShoppingCartException(productId, username);
        }
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}