package mk.ukim.finki.wpaud.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.model.Manufacturer;
import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Software", "Software Category"));
        categories.add(new Category("Books", "Book Category"));

        users.add(new User("dulev.nikola", "nd", "Nikola", "Dulev"));
        users.add(new User("atashev", "at", "Aleksandar", "Tashev"));
        users.add(new User("stefan.tagarski", "st", "Stefan", "Tagarski"));

        Manufacturer manufacturer = new Manufacturer("Nike", "New York City, NY");
        manufacturers.add(manufacturer);

        Category category = new Category("Sport", "Sport Category");
        categories.add(category);
        products.add(new Product("Ball 1", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 2", 236.8, 4, category, manufacturer));
        products.add(new Product("Ball 3", 237.8, 8, category, manufacturer));
    }
}
