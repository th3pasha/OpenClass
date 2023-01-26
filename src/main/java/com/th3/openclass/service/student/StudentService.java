package com.th3.openclass.service.student;

import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Student create(final StudentCommand studentCommand);
    Student findStudentById(String studentId);
    Page<Student> getStudents(Pageable pageable);

}
