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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    // map to instructor ManyToOne
    @ManyToOne
    private Instructor instructor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Course))
            return false;

        Course other = (Course) o;

        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor='" + instructor.getId() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
