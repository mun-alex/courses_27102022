package kz.bitlab.courses.controllers;

import kz.bitlab.courses.models.Category;
import kz.bitlab.courses.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private Category category;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    String getAllCategories(Model model) {
        model.addAttribute("newCategory", category);
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "categories";
    }

    @PostMapping(value = "/add")
    String addCategory(@ModelAttribute(name = "newCategory") Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping(value = "/edit/{id}")
    String getEditForm(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("category", categoryRepository.findById(id).orElseThrow());
        return "editCategory";
    }
}
