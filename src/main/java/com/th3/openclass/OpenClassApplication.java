package com.th3.openclass;

import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication()
public class OpenClassApplication
{
    Student student;

    public static void main(String[] args)
    {
        SpringApplication.run(OpenClassApplication.class, args);

    }

//    @Bean
//    CommandLineRunner commandLineRunner(@Autowired StudentRepository studentRepository)
//    {
//        return args -> {
//            student = new Student(
//                    211L,
//                    "ayoub",
//                    "azizi",
//                    "email@email.com" );
//            studentRepository.save(student);
//        };
//    }

}
