package com.th3.openclass.command;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FieldCommand {
    private String fieldName;
    private String fieldLabel;

    void validate(){

    }
}
