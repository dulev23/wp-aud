package mk.ukim.finki.wpaud.service;

import mk.ukim.finki.wpaud.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category create(String name, String description);

    Category update(String name, String description);

    void delete(String name);

    void deleteById(Long id);

    List<Category> listCategories();

    List<Category> searchCategories(String searchText);

    Optional<Category> findById(Long id);
}
