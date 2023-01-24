package com.th3.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Student")
public class Student
{
    @Id
    private Long apogeeNum;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Date birthDate;
    private Date enrolDate;
    private Date exprDate;


    public Student(Long apogeeNum,
                   String firstName,
                   String lastName,
                   String email,
                   Integer age,
                   Date birthDate,
                   Date enrolDate,
                   Date exprDate
    ) {
        this.apogeeNum = apogeeNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.enrolDate = enrolDate;
        this.exprDate = exprDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", enrolDate=" + enrolDate +
                ", exprDate=" + exprDate +
                '}';
    }
}
