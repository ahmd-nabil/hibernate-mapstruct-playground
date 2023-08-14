package nabil.hibernateadvancedmapping.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nabil.hibernateadvancedmapping.entities.InstructorDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ahmed Nabil
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InstructorDto {

    @Builder.Default
    Set<CourseDto> courseDtos = new HashSet<>();
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetails instructorDetails;

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetails=" + instructorDetails +
                ", courses=" + courseDtos +
                '}';
    }
}
