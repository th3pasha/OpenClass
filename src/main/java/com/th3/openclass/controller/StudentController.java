package com.th3.openclass.controller;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.dto.StudentDto;
import com.th3.openclass.dto.mapper.StudentMapper;
import com.th3.openclass.model.Student;
import com.th3.openclass.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.th3.openclass.constants.ResourcePath.STUDENT;
import static com.th3.openclass.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + STUDENT)
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;


    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody final StudentCommand studentCommand){
        final Student student = studentService.create(studentCommand);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }
}
