package com.th3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Field")
public class Field {
    @Id
    private Long id;
    private String fieldName;
    private String fieldLabel;

    public Field(Long id, String fieldName, String fieldLabel) {
        this.id = id;
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
    }

    public Field() {

    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", fieldName='" + fieldName + '\'' +
                ", fieldLabel='" + fieldLabel + '\'' +
                '}';
    }

}
