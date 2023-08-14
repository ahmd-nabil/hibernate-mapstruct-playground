package nabil.hibernateadvancedmapping.repositories;

import nabil.hibernateadvancedmapping.entities.Course;
import nabil.hibernateadvancedmapping.entities.Instructor;
import nabil.hibernateadvancedmapping.entities.InstructorDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

/**
 * @author Ahmed Nabil
 */
@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;
    Instructor ahmed;
    InstructorDetails details;

    Course course1;
    Course course2;

    @BeforeEach
    void setUp() {
        ahmed = Instructor
                .builder()
                .firstName("ahmed")
                .lastName("nabil")
                .email("ahmednabil@gmail.com")
                .build();

        details = InstructorDetails.builder()
                .facebookPage("facebook.com")
                .build();
        ahmed.setInstructorDetails(details);

        course1 = Course.builder()
                .title("Algo1")
                .build();
        course2 = Course.builder()
                .title("Algo2")
                .build();
    }

    @Test
    void test_save_instructor_with_details_success() {
        instructorRepository.save(ahmed);

        Assertions.assertThat(ahmed.getId()).isNotNull();
        Assertions.assertThat(details.getId()).isEqualTo(ahmed.getId());
    }

    @Test
    void test_cascade_save_to_course_success() {
        courseRepository.save(course1);
        courseRepository.flush();
        ahmed.addCourse(course1);
        ahmed.addCourse(course2);
        Instructor savedInstructor = instructorRepository.save(ahmed);
        List<Course> courses = courseRepository.findByInstructorId(savedInstructor.getId());
        Assertions.assertThat(savedInstructor.getCourses().size()).isEqualTo(2);
        Assertions.assertThat(courses.size()).isEqualTo(2);
    }
}