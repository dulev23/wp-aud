package mk.ukim.finki.wpaud.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Software", "Software Category"));
        categories.add(new Category("Books", "BookCategory"));

        users.add(new User("dulev.nikola","nd","Nikola","Dulev"));
        users.add(new User("atashev","at","Aleksandar","Tashev"));
        users.add(new User("stefan.tagarski","st","Stefan","Tagarski"));
    }
}
