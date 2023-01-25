package com.th3.openclass.model;

import com.th3.openclass.command.FieldCommand;
import jakarta.persistence.*;

@Entity
@Table(name = "FIELD", uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = "id")
})
public class Field extends BaseEntity{
    @Column(name = "field_name", nullable = false, updatable = false)
    private String fieldName;
    @Column(name = "field_label", nullable = false, updatable = false)
    private String fieldLabel;

    public static Field create(final FieldCommand fieldCommand){
        final Field field = new Field();

        field.fieldLabel = fieldCommand.getFieldLabel();
        field.fieldName = fieldCommand.getFieldName();
        return field;
    }

}
