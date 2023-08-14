package nabil.hibernateadvancedmapping.repositories;

import nabil.hibernateadvancedmapping.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ahmed Nabil
 */
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
