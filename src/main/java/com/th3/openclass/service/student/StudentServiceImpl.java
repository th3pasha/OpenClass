package com.th3.openclass.service.student;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.command.StudentUpdateCommand;
import com.th3.openclass.exception.BusinessException;
import com.th3.openclass.exception.ExceptionPayloadFactory;
import com.th3.openclass.model.Student;
import com.th3.openclass.repository.PostRepository;
import com.th3.openclass.repository.StudentRepository;
import com.th3.openclass.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public Student create(StudentCommand studentCommand) {
        studentCommand.validate();
        log.info("Begin creating student with payload {}", JSONUtil.toJSON(studentCommand));
        final Student student = studentRepository.save(Student.create(studentCommand));
        return student;
    }

    @Override
    public Student findStudentById(String studentId) {
        log.info("Begin fetching student with id {}", studentId);
        final Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.STUDENT_NOT_FOUND.get())
        );
        log.info("Student with id {} fetched successfully", studentId);
        return student;
    }

    @Override
    public Student updateInfo(String studentId, StudentUpdateCommand updateCommand) {
        final Student student = findStudentById(studentId);
        log.info("Begin updating student with id {} with payload {}", studentId, JSONUtil.toJSON(updateCommand));
        updateCommand.validate();
        student.update(updateCommand);
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}
