package com.th3.openclass.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCommand {
    private String email;
    private String password;

    public void validate(){

    }
}
