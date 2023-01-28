package com.th3.openclass.controller;


import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.command.StudentUpdateCommand;
import com.th3.openclass.dto.StudentDto;
import com.th3.openclass.dto.mapper.StudentMapper;
import com.th3.openclass.model.Student;
import com.th3.openclass.service.student.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.th3.openclass.constants.ResourcePath.STUDENT;
import static com.th3.openclass.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + STUDENT)
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;


    @PostMapping
    @ApiOperation(value = "API TO CREATE STUDENT")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDto> create(@RequestBody final StudentCommand studentCommand){
        final Student student = studentService.create(studentCommand);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }
    @GetMapping("/{studentId}")
    @ApiOperation(value = "API TO GET STUDENT BY ID")
    public ResponseEntity<StudentDto> getById(@PathVariable("studentId") final String studentId){
        final Student student = studentService.findStudentById(studentId);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }
    @GetMapping
    @ApiOperation(value = "API TO GET ALL STUDENTS")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<StudentDto>> getStudents(Pageable pageable){
        return ResponseEntity.ok(studentService.getStudents(pageable).map(studentMapper::toDto));
    }
    @PutMapping("/{studentId}")
    @ApiOperation(value = "API TO UPDATE STUDENT WITH ID")
    @PreAuthorize("hasRole('ADMIN') or #studentId == authentication.principal.studentId")
    public ResponseEntity<StudentDto> update(@PathVariable("studentId") final String studentId,
                                             @RequestBody final StudentUpdateCommand studentUpdateCommand){
        final Student student = studentService.updateInfo(studentId, studentUpdateCommand);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }
}
