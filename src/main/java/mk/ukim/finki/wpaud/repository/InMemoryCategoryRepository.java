package mk.ukim.finki.wpaud.repository;

import mk.ukim.finki.wpaud.bootstrap.DataHolder;
import mk.ukim.finki.wpaud.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryCategoryRepository {

    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public Category save(Category c) {
        if (c == null || c.getName() == null || c.getName().isEmpty()) {
            return null;
        }
        DataHolder.categories.removeIf(category -> category.getName().equals(c.getName()));
        DataHolder.categories.add(c);
        return c;
    }

    public Optional<Category> findByName(String name) {
        return DataHolder.categories.stream().filter(category -> category.getName().equals(name)).findFirst();
    }

    public List<Category> search(String text) {
        return DataHolder.categories.stream()
                .filter(category -> category.getName().contains(text) ||
                        category.getDescription().contains(text))
                .collect(Collectors.toList());
    }

    public void delete(String name) {
        if (name == null) {
            return;
        }
        DataHolder.categories.removeIf(category -> category.getName().equals(name));
    }
}
