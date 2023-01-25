package com.th3.openclass.model;

import com.th3.openclass.command.FieldCommand;
import com.th3.openclass.command.StudentCommand;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "FIELD", uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = "id")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Field extends BaseEntity{
    @Column(name = "field_name", nullable = false, updatable = false)
    private String fieldName;
    @Column(name = "field_label", nullable = false, updatable = false)
    private String fieldLabel;

    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students;

    public static Field create(final FieldCommand fieldCommand){
        final Field field = new Field();

        field.fieldLabel = fieldCommand.getFieldLabel();
        field.fieldName = fieldCommand.getFieldName();
        field.students = createStudentPayload(fieldCommand.getStudentCommands());

        return field;
    }
    public Student addStudent(final StudentCommand studentCommand){
        studentCommand.validate(); // validate email
        final Student student = Student.create(studentCommand);
        this.students.add(student);
        student.linkToField(this);
        return student;
    }
    public static List<Student> createStudentPayload(List<StudentCommand> studentCommands){
        return studentCommands.stream().map(Student::create).collect(Collectors.toList());
    }
}
