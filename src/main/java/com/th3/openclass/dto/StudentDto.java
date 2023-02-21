package com.th3.openclass.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class StudentDto
{
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String password;
    private String avatarUrl;
    private Date birthDate;
    private List<PostDto> posts;
}
