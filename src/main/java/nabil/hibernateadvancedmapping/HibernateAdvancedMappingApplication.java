package nabil.hibernateadvancedmapping;

import nabil.hibernateadvancedmapping.entities.Course;
import nabil.hibernateadvancedmapping.entities.Instructor;
import nabil.hibernateadvancedmapping.entities.InstructorDetails;
import nabil.hibernateadvancedmapping.repositories.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateAdvancedMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateAdvancedMappingApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(InstructorRepository instructorRepository) {
        return args -> {
            System.out.println("Commandline Runner");
            Instructor ins1 = Instructor
                    .builder()
                    .firstName("Ahmed")
                    .lastName("Nabil")
                    .email("ahmed.nabil@datagearbi.com")
                    .build();
            InstructorDetails insDetails1 = InstructorDetails
                    .builder()
                    .facebookPage("facebook/ahmednabil")
                    .about("I am a software engineer")
                    .build();
            ins1.setInstructorDetails(insDetails1);
            Course c1 = Course.builder().title("c1").build();
            Course c2 = Course.builder().title("c2").build();
            ins1.addCourse(c1);
            ins1.addCourse(c2);
            instructorRepository.save(ins1);
        };
    }
}
