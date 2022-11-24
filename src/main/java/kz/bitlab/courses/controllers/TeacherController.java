package kz.bitlab.courses.controllers;

import kz.bitlab.courses.models.Teacher;
import kz.bitlab.courses.repositories.CourseRepository;
import kz.bitlab.courses.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/teachers")
public class TeacherController {

    @Autowired
    private Teacher teacher;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    String getAllTeachers(Model model) {
        model.addAttribute("teacherList", teacherRepository.findAll());
        model.addAttribute("newTeacher", teacher);
        model.addAttribute("courseList", courseRepository.findAll());
        return "teachers";
    }

}
