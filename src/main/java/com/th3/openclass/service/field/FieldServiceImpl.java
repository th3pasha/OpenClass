package com.th3.openclass.service.field;


import com.th3.openclass.command.FieldCommand;
import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.exception.BusinessException;
import com.th3.openclass.exception.ExceptionPayloadFactory;
import com.th3.openclass.model.Field;
import com.th3.openclass.model.Student;
import com.th3.openclass.repository.FieldRepository;
import com.th3.openclass.repository.StudentRepository;
import com.th3.openclass.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FieldServiceImpl implements FieldService{

    private final FieldRepository fieldRepository;

    @Override
    public Field addStudentToField(String fieldId, StudentCommand studentCommand) {
        final Field field = findFieldById(fieldId);
        log.info("Begin add student with payload {} to field with id {}", JSONUtil.toJSON(studentCommand), fieldId);
        field.addStudent(studentCommand);
        log.info("Student with payload {} added to field with id {} successfully", JSONUtil.toJSON(studentCommand), fieldId);
        return fieldRepository.save(field);
    }

    @Override
    public Field findFieldById(String fieldId) {
        log.info("Begin fetching field with id {}", fieldId);
        final Field field = fieldRepository.findById(fieldId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.FIELD_NOT_FOUND.get())
        );
        return field;
    }
    @Override
    public Field createField(final FieldCommand fieldCommand){
        log.info("Begin creating field with payload {}", JSONUtil.toJSON(fieldCommand));
        final Field field = fieldRepository.save(Field.create(fieldCommand));
        log.info("Field with id {} created successfully", field.getId());
        return field;
    }

    @Override
    public Page<Field> getFields(Pageable pageable) {
        return fieldRepository.findAll(pageable);
    }
}
