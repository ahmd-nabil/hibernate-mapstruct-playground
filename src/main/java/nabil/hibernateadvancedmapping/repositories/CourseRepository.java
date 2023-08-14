package nabil.hibernateadvancedmapping.repositories;

import nabil.hibernateadvancedmapping.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ahmed Nabil
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByInstructorId(Integer id);
}
