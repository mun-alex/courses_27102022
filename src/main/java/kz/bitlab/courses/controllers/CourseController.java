package kz.bitlab.courses.controllers;

import kz.bitlab.courses.models.Course;
import kz.bitlab.courses.repositories.CategoryRepository;
import kz.bitlab.courses.repositories.CourseRepository;
import kz.bitlab.courses.services.CategoryService;
import kz.bitlab.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Course course;

    @GetMapping
    String getAllCourses(Model model) {
        model.addAttribute("newCourse", course);
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("coursesList", courseService.getAllCourses());
        return "courses";
    }

    @PostMapping(value = "/add")
    String addCourse(@ModelAttribute(name = "newCourse") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping(value = "/edit/{courseId}")
    String getDetails(Model model, @PathVariable(name = "courseId") Long courseId) {
        try {
            model.addAttribute("categoryList", categoryService.getAllCategories());
            model.addAttribute("course", courseService.getCourseById(courseId));
            return "editCourse";
        } catch (NoSuchElementException e) {
            return "editCourse?error";
        }
    }
}
