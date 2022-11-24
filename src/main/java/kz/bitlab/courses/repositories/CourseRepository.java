package kz.bitlab.courses.repositories;

import kz.bitlab.courses.models.Category;
import kz.bitlab.courses.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByCategory_Id(Long id);
}
