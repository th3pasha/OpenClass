package com.th3.openclass.api;

import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/students")
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


    @GetMapping
    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }

    @PostMapping
    public void addStudent(@RequestBody NewStudentRequest newStudentRequest)
    {
        Student student = new Student();
        student.setApogeeNum(newStudentRequest.apogeeNum);
        student.setFirstName(newStudentRequest.firstName);
        student.setLastName(newStudentRequest.lastName);
        student.setEmail(newStudentRequest.email);
        student.setAge(newStudentRequest.age);
        student.setAvatarUrl(newStudentRequest.avatarUrl);
        student.setBirthDate(newStudentRequest.birthDate);
        student.setEnrolDate(newStudentRequest.enrolDate);
        student.setExprDate(newStudentRequest.exprDate);

        studentRepository.save(student);
    }
}

