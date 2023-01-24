package com.th3.openclass;

import com.th3.model.Student;
import com.th3.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan("com.th3.model")
@SpringBootApplication(scanBasePackages ={"com.th3.repository"})
public class OpenClassApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(OpenClassApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository)
    {
        return args -> {
            Student student = new Student(
                    02111150L,
                    "ayoub",
                    "azizi",
                    "email@email.com" );
            studentRepository.save(student);
        };
    }

}
