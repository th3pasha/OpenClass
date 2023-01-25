package com.th3.openclass.controller;

import com.th3.openclass.api.StudentService;
import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
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

    @PostMapping
    public void addStudent(@RequestBody final String email)
    {
        Student student = new Student((long)15, "ayoub","azizi",email);
        studentService.addStudent(student);
    }

    @GetMapping("get")
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }

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

}
