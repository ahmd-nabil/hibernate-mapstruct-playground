package nabil.hibernateadvancedmapping.mappers;

import nabil.hibernateadvancedmapping.dtos.InstructorDto;
import nabil.hibernateadvancedmapping.entities.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Ahmed Nabil
 */
@Mapper(uses = {CourseMapper.class})
public interface InstructorMapper {
    @Mapping(target = "courseDtos", source = "courses")
    InstructorDto instructorToDto(Instructor instructor);

    @Mapping(target = "courses", source = "courseDtos")
    Instructor dtoToInstructor(InstructorDto dto);
}
