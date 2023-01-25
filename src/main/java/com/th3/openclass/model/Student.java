package com.th3.openclass.model;

import com.th3.openclass.command.StudentCommand;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "STUDENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Student extends BaseEntity{

    @Column(name = "apogee_num")
    private Long apogeeNum;
    @Column(name = "first_name", updatable = false)
    private String firstName;
    @Column(name = "last_name", updatable = false)
    private String lastName;
    @Column(name = "email_adress", updatable = false, unique = true)
    private String email;
    @Column(name = "age")
    private Integer age;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "birth_date", updatable = false)
    private Date birthDate;
    @Column(name = "enrol_date", updatable = false)
    private Date enrolDate;
    @Column(name = "expr_date")
    private Date exprDate;

    @ManyToOne
    private Field field;

    public static Student create(final StudentCommand studentCommand)
    {
        final Student student = new Student();

        student.email = studentCommand.getEmail();
        student.firstName = getFirstNameFromEmail(studentCommand);
        student.lastName = getLastNameFromEmail(studentCommand, student.firstName.length());
        return student;
    }
    public static String getFirstNameFromEmail(final StudentCommand studentCommand){
        // anas.abbal20@ump.ac.ma
        int lengthFirstName = 0;
        String email = studentCommand.getEmail();
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) != '.')
                lengthFirstName++;
            if(email.charAt(i) == '.'){
                break;
            }
        }
        // create space address exactly for firstName
        char[] first = new char[lengthFirstName];

        for(int i = 0; i < lengthFirstName; i++){
            // init firstName
            first[i] = email.charAt(i);
        }
        return new String(first);
    }
    public static String getLastNameFromEmail(final StudentCommand studentCommand, int lengthFirstName){
        // anas.abbal20@ump.ac.ma
        int count = 0;
        // get email from request body
        final String email = studentCommand.getEmail();
        // create space address exactly for lastName
        int lengthLastName = 0;
        lengthFirstName += 1;
        for(int i = lengthFirstName; i < email.length() - 1; i++){
            if(email.charAt(i) != '@'){
                lengthLastName++;
            }
            if(email.charAt(i) == '@')
                break;
        }
        lengthLastName -= 2;
        int cnt = 0;
        char[] last = new char[lengthLastName];
        for(int i = lengthFirstName; i < lengthLastName + lengthFirstName; i++){
            last[cnt] = email.charAt(i);
            cnt++;
        }
        return new String(last);
    }
    public void linkToField(Field field)
    {
        this.field = field;
    }
}
