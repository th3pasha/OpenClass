package com.th3.openclass.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FieldDto {
    private String id;
    private String fieldName;
    private String fieldLabel;
    private List<StudentDto> students;
}
