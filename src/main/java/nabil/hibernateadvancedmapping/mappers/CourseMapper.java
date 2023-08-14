package nabil.hibernateadvancedmapping.mappers;

import nabil.hibernateadvancedmapping.dtos.CourseDto;
import nabil.hibernateadvancedmapping.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Ahmed Nabil
 */
@Mapper
public interface CourseMapper {
    @Mapping(target = "instructorId", source = "instructor.id")
    @Mapping(target = "instructorFirstName", source = "instructor.firstName")
    @Mapping(target = "instructorLastName", source = "instructor.lastName")
    CourseDto courseToDto(Course course);
}
