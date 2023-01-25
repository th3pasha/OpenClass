package com.th3.openclass.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "STUDENT", uniqueConstraints = {
        @UniqueConstraint(name = "email_adress", columnNames = "email_adress")
})
public class Student
{
    @Id
    @Column(name = "apogee_num")
    private Long apogeeNum;
    @Column(name = "first_name", updatable = false)
    private String firstName;
    @Column(name = "last_name", updatable = false)
    private String lastName;
    @Column(name = "email_adress", updatable = false, unique = true)
    private String email;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "birth_date", updatable = false)
    private Date birthDate;
    @Column(name = "enrol_date", updatable = false)
    private Date enrolDate;
    @Column(name = "expr_date")
    private Date exprDate;

    public Student(Long apogeeNum,
                   String firstName,
                   String lastName,
                   String email,
                   String avatarUrl,
                   Date birthDate,
                   Date enrolDate,
                   Date exprDate
    ) {
        this.apogeeNum = apogeeNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatarUrl= avatarUrl;
        this.birthDate = birthDate;
        this.enrolDate = enrolDate;
        this.exprDate = exprDate;
    }

    public Student(Long apogeeNum, String firstName, String lastName, String email) {
        this.apogeeNum = apogeeNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {

    }

    public Long getApogeeNum() {
        return apogeeNum;
    }

    public void setApogeeNum(Long apogeeNum) {
        this.apogeeNum = apogeeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public Date getExprDate() {
        return exprDate;
    }

    public void setExprDate(Date exprDate) {
        this.exprDate = exprDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "apogeeNum=" + apogeeNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", birthDate=" + birthDate +
                ", enrolDate=" + enrolDate +
                ", exprDate=" + exprDate +
                '}';
    }

    @ManyToOne(optional = true)
    private Field student;

    public Field getStudent() {
        return student;
    }

    public void setStudent(Field student) {
        this.student = student;
    }
}
