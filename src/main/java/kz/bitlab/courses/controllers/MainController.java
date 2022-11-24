package kz.bitlab.courses.controllers;

import kz.bitlab.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    String getAllCourses(Model model) {
        model.addAttribute("coursesList", courseRepository.findAll());
        return "index";
    }
}
