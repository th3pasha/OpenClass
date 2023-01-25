package com.th3.openclass.dto.mapper;


import com.th3.openclass.dto.FieldDto;
import com.th3.openclass.model.Field;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FieldMapper {
    FieldDto toDto(Field field);
}