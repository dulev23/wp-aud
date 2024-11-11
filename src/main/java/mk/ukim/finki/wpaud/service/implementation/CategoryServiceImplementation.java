package mk.ukim.finki.wpaud.service.implementation;

import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.repository.InMemoryCategoryRepository;
import mk.ukim.finki.wpaud.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {
    private final InMemoryCategoryRepository categoryRepository;

    public CategoryServiceImplementation(InMemoryCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Optional<Category> create(String name, String description) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Category c = new Category(name, description);
        return categoryRepository.save(c);
    }

    @Override
    public Optional<Category> update(String name, String description) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Category c = new Category(name, description);
        return categoryRepository.save(c);
    }

    @Override
    public void delete(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        categoryRepository.delete(name);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return categoryRepository.search(searchText);
    }

    @Override
    public Optional<Category> findById(Long id){
        return this.categoryRepository.findById(id);
    }
}
