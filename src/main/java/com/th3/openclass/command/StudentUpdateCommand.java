package com.th3.openclass.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateCommand {
    private String firstName;
    private String lastName;
    private String avatarUrl;

    public void validate(){

    }
}
