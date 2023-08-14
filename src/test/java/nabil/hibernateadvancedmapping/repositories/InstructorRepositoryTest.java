package nabil.hibernateadvancedmapping.repositories;

import nabil.hibernateadvancedmapping.entities.Instructor;
import nabil.hibernateadvancedmapping.entities.InstructorDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author Ahmed Nabil
 */
@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    InstructorRepository instructorRepository;
    Instructor ahmed;
    InstructorDetails details;

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
    }

    @Test
    void test_save_instructor_with_details_success() {
        instructorRepository.save(ahmed);

        Assertions.assertThat(ahmed.getId()).isNotNull();
        Assertions.assertThat(details.getId()).isEqualTo(ahmed.getId());
    }
}