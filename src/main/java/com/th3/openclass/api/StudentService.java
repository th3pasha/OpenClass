package com.th3.openclass.api;

import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class StudentService
{
    private final StudentRepository studentRepository;

    record NewStudentRequest(
            Long apogeeNum,
            String firstName,
            String lastName,
            String email,
            Integer age,
            String avatarUrl,
            Date birthDate,
            Date enrolDate,
            Date exprDate
    )
    { }

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//
//    @GetMapping("/")
//    public String index()
//    {
//        return "index";
//    }
//    @PostMapping("/register")
//    public String studentRegistration(@ModelAttribute Student student)
//    {
//        studentRepository.save(student);
//        return "index";
//    }
    @GetMapping("home")
    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }

    @PostMapping
    public void addStudent(@RequestBody NewStudentRequest newStudentRequest)
    {
        Student student = new Student();
        student.setEmail(newStudentRequest.email);
        studentRepository.save(student);
    }



}

