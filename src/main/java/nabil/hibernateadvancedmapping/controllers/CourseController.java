package nabil.hibernateadvancedmapping.controllers;

import lombok.RequiredArgsConstructor;
import nabil.hibernateadvancedmapping.dtos.CourseDto;
import nabil.hibernateadvancedmapping.mappers.CourseMapper;
import nabil.hibernateadvancedmapping.repositories.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ahmed Nabil
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @GetMapping
    public List<CourseDto> findAll() {
        return courseRepository.findAll().stream().map(courseMapper::courseToDto).toList();
    }
}
