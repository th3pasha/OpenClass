package com.th3.openclass.service;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.dto.StudentDto;
import com.th3.openclass.model.Student;
import com.th3.openclass.repository.StudentRepository;
import com.th3.openclass.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;


    @Override
    public Student create(StudentCommand studentCommand) {
        studentCommand.validate();
        log.info("Begin creating student with payload {}", JSONUtil.toJSON(studentCommand));
        final Student student = studentRepository.save(Student.create(studentCommand));
        return student;
    }
}
