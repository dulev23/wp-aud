package mk.ukim.finki.wpaud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wpaud.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category("Food", "Food Category"));
        categories.add(new Category("Books", "Book Category"));
        categories.add(new Category("Sports", "Sports Category"));

        users = new ArrayList<>();
        users.add(new User("dulev.nikola", "nd", "Nikola", "Dulev"));
        users.add(new User("atashev", "at", "Aleksandar", "Tashev"));
        users.add(new User("stefan.tagarski", "st", "Stefan", "Tagarski"));

        manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("Nike", "USA"));
        manufacturers.add(new Manufacturer("Coca-Cola", "USA"));
        manufacturers.add(new Manufacturer("Literatura", "MK"));

        products = new ArrayList<>();
        products.add(new Product("Nike AirForce 1", 235.8, 7, categories.get(2), manufacturers.get(0)));
        products.add(new Product("Coca-Cola 2L", 2.0, 100, categories.get(0), manufacturers.get(1)));
        products.add(new Product("A song of Ice and Fire", 20.0, 8, categories.get(1), manufacturers.get(2)));
    }
}
