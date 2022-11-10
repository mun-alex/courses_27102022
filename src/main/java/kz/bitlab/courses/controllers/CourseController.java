package kz.bitlab.courses.controllers;

import kz.bitlab.courses.models.Course;
import kz.bitlab.courses.repositories.CategoryRepository;
import kz.bitlab.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Course course;

    @GetMapping
    String getAllCourses(Model model) {
        model.addAttribute("newCourse", course);
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("coursesList", courseRepository.findAll());
        return "courses";
    }

    @PostMapping(value = "/add")
    String addCourse(@ModelAttribute(name = "newCourse") Course course) {
        courseRepository.save(course);
        return "redirect:/courses";
    }

    @GetMapping(value = "/edit/{courseId}")
    String getDetails(Model model, @PathVariable(name = "courseId") Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("course", course);
        return "editCourse";
    }

}
