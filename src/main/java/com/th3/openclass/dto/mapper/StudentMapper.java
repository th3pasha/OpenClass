package com.th3.openclass.dto.mapper;


import com.th3.openclass.dto.StudentDto;
import com.th3.openclass.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
}
