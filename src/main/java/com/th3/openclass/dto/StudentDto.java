package com.th3.openclass.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;




@Getter
@Setter
@NoArgsConstructor
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String avatarUrl;
    private Date birthDate;
}
