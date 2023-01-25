package com.th3.openclass.controller;

import com.th3.openclass.api.StudentService;
import com.th3.openclass.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class Controller
{
    private StudentService studentService;

    @GetMapping
    public String greet()
    {
          return  "Hello";
    }

    @GetMapping("api/unsecured")
    public List<Student> getStudents()
    {
        return  studentService.getStudent();
    }


}
