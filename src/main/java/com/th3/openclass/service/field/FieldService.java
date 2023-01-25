package com.th3.openclass.service.field;

import com.th3.openclass.command.FieldCommand;
import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.model.Field;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FieldService {
    Field addStudentToField(String fieldId, final StudentCommand studentCommand);
    Field findFieldById(String fieldId);
    Field createField(final FieldCommand fieldCommand);
    Page<Field> getFields(Pageable pageable);
}
