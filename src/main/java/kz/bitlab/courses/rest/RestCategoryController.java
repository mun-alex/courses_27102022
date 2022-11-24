package kz.bitlab.courses.rest;

import kz.bitlab.courses.models.Category;
import kz.bitlab.courses.repositories.CategoryRepository;
import kz.bitlab.courses.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/categories")
public class RestCategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping(value = "/{id}")
    public Category getCategory(@PathVariable(name = "id") Long id) {
        return categoryService.getCategoryById(id);
    }
}
