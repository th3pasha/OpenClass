package com.th3.openclass.command;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FieldCommand
{
    private String fieldName;
    private String fieldLabel;
    private List<StudentCommand> studentCommands;

    void validate(){

    }
}
