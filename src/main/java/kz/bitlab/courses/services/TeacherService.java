package kz.bitlab.courses.services;

import kz.bitlab.courses.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    void saveTeacher(Teacher teacher);

    Optional<Teacher> getTeacherById(Long id);

    void deleteTeacherById(Long id);
}
