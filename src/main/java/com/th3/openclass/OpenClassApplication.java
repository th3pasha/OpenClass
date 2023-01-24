package com.th3.openclass;

import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication()
public class OpenClassApplication
{
    // TODO fix package problem, bean problem

    Student student;

    public static void main(String[] args)
    {
        SpringApplication.run(OpenClassApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(@Autowired StudentRepository studentRepository)
    {
        return args -> {
             student = new Student(
                        211L,
                    "ayoub",
                    "azizi",
                    "email@email.com" );
             Student student2 = new Student(
                     2654L,
                     "younes",
                     "ouartassi",
                     "email@cil.com"

             );
            studentRepository.save(student2);
            studentRepository.save(student);
        };
    }

}
