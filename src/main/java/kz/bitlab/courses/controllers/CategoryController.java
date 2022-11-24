package kz.bitlab.courses.controllers;

import kz.bitlab.courses.models.Category;
import kz.bitlab.courses.repositories.CategoryRepository;
import kz.bitlab.courses.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private Category category;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    String getAllCategories(Model model) {
        model.addAttribute("newCategory", category);
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "categories";
    }

    @PostMapping(value = "/add")
    String addCategory(@ModelAttribute(name = "newCategory") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping(value = "/edit/{id}")
    String getEditForm(Model model, @PathVariable(name = "id") Long id) {
        try {
            model.addAttribute("category", categoryService.getCategoryById(id));
            return "editCategory";
        } catch (NoSuchElementException e) {
            return "redirect:/categories?error";
        }
    }
}
