package com.th3.openclass.controller;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.dto.StudentDto;
import com.th3.openclass.dto.mapper.StudentMapper;
import com.th3.openclass.model.Student;
import com.th3.openclass.service.student.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.th3.openclass.constants.ResourcePath.STUDENT;
import static com.th3.openclass.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + STUDENT)
@CrossOrigin("*")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/email/{studentEmail}")
    @CrossOrigin("*")
    @ApiOperation(value = "API TO GET STUDENT NAME BY EMAIL")
    public ResponseEntity<StudentDto> getStudentByEmail(@PathVariable("studentEmail") final String studentEmail)
    {
        final Student student = studentService.findStudentByEmail(studentEmail);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }


    @PostMapping
    @ApiOperation(value = "API TO CREATE STUDENT")
    public ResponseEntity<StudentDto> create(@RequestBody final StudentCommand studentCommand)
    {
        final Student student = studentService.createStudent(studentCommand);

        return ResponseEntity.ok(studentMapper.toDto(student));
    }
    @GetMapping("/{studentId}")
    @ApiOperation(value = "API TO GET STUDENT BY ID")
    public ResponseEntity<StudentDto> getById(@PathVariable("studentId") final String studentId)
    {
        final Student student = studentService.findStudentById(studentId);

        return ResponseEntity.ok(studentMapper.toDto(student));
    }
    @GetMapping
    @ApiOperation(value = "API TO GET ALL STUDENTS")
    public ResponseEntity<Page<StudentDto>> getStudents(Pageable pageable)
    {
        return ResponseEntity.ok(studentService.getStudents(pageable).map(studentMapper::toDto));
    }
}
