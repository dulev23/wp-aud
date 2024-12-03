package mk.ukim.finki.wpaud.service;

import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Product> listAllProductsInShoppingCart(Long shoppingCartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);
}
