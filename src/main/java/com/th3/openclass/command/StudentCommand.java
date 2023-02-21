package com.th3.openclass.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCommand
{
    private String email;
    private String password;
    private String age;
    private String avatarUrl;

    public void validate(){

    }
}
