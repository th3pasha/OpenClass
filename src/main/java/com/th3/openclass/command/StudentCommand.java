package com.th3.openclass.command;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentCommand
{
    private String email;
    private String password;
    private Long apogeeNum;
    private Date birthDate;
    private String avatarUrl;

    public void validate(){

    }
}
