package kz.bitlab.courses.services;

import kz.bitlab.courses.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    List<Course> getCoursesByCategoryId(Long id);

    void saveCourse(Course course);

    Course getCourseById(Long id);

    void deleteCourseById(Long id);
}
