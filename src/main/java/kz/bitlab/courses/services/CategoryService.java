package kz.bitlab.courses.services;

import kz.bitlab.courses.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    void saveCategory(Category category);

    Category getCategoryById(Long id);

    void deleteCategoryById(Long id);
}
