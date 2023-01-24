package com.th3.openclass.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FIELD", uniqueConstraints = {
        @UniqueConstraint(name = "id", columnNames = "id")
})
public class Field {
    @Id
    private Long id;
    @Column(name = "field_name", nullable = false, updatable = false)
    private String fieldName;
    @Column(name = "field_label", nullable = false, updatable = false)
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
