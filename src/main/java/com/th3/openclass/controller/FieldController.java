package com.th3.openclass.controller;


import com.th3.openclass.command.FieldCommand;
import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.dto.FieldDto;
import com.th3.openclass.dto.mapper.FieldMapper;
import com.th3.openclass.model.Field;
import com.th3.openclass.service.field.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.th3.openclass.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + FIELDS)
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;
    private final FieldMapper fieldMapper;


    @PostMapping("/{fieldId}" + STUDENT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FieldDto> addToField(@PathVariable("fieldId") final String fieldId,
                                               @RequestBody final StudentCommand studentCommand){
        final Field field = fieldService.addStudentToField(fieldId, studentCommand);
        return ResponseEntity.ok(fieldMapper.toDto(field));
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FieldDto> createField(@RequestBody final FieldCommand fieldCommand){
        final Field field = fieldService.createField(fieldCommand);
        return ResponseEntity.ok(fieldMapper.toDto(field));
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<FieldDto>> getFields(Pageable pageable){
        return ResponseEntity.ok(fieldService.getFields(pageable).map(fieldMapper::toDto));
    }
}
