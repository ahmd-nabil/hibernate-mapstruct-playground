package nabil.hibernateadvancedmapping.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ahmed Nabil
 */
@Entity
@Table(name = "instructor_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String facebookPage;
    private String about;
}
