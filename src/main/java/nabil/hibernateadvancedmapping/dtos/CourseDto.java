package nabil.hibernateadvancedmapping.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ahmed Nabil
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CourseDto {
    private Integer id;
    private String title;
    private String description;
    private Integer instructorId;
    private String instructorFirstName;
    private String instructorLastName;

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructorId=" + instructorId +
                ", instructorName='" + instructorFirstName + " " + instructorLastName + '\'' +
                '}';
    }
}
