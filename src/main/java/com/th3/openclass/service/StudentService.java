package com.th3.openclass.service;

import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.model.Student;

public interface StudentService {
    Student create(final StudentCommand studentCommand);
}
