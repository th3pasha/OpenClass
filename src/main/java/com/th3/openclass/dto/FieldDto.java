package com.th3.openclass.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FieldDto
{
    private String fieldName;
    private String fieldLabel;
    private List<StudentDto> students;
}
