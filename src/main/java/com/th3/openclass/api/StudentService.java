package com.th3.openclass.api;

import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }

    public void addStudent(Student student)
    {
        studentRepository.save(student);
    }
}



