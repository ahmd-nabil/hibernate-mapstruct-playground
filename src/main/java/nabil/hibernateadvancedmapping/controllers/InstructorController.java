package nabil.hibernateadvancedmapping.controllers;

import lombok.RequiredArgsConstructor;
import nabil.hibernateadvancedmapping.dtos.InstructorDto;
import nabil.hibernateadvancedmapping.mappers.InstructorMapper;
import nabil.hibernateadvancedmapping.repositories.InstructorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ahmed Nabil
 */
@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @GetMapping
    List<InstructorDto> findAll() {
        return instructorRepository.findAll().stream().map(instructorMapper::instructorToDto).toList();
    }
}
