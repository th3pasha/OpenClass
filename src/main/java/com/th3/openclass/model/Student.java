package com.th3.openclass.model;

import com.th3.openclass.command.PostCommand;
import com.th3.openclass.command.StudentCommand;
import com.th3.openclass.command.StudentUpdateCommand;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "birth_date", updatable = false)
    private Date birthDate;
    @Column(name = "enrol_date", updatable = false)
    private Date enrolDate;
    @Column(name = "expr_date")
    private Date exprDate;
    @OneToMany(mappedBy = "student")
    private List<Post> posts;

    @ManyToOne
    private Field field;

    public static Student create(final StudentCommand studentCommand){
        final Student student = new Student();

        student.email = studentCommand.getEmail();
        student.apogeeNum = studentCommand.getApogeeNum();
        student.firstName = getFirstNameFromEmailStudentCommand(studentCommand);
        student.lastName = getLastNameFromEmail(studentCommand.getEmail(), student.firstName.length());
        return student;
    }
    public void update(final StudentUpdateCommand studentUpdateCommand){
        this.firstName = studentUpdateCommand.getFirstName();
        this.lastName = studentUpdateCommand.getLastName();
        this.avatarUrl = studentUpdateCommand.getAvatarUrl();
    }
    public static String getFirstNameFromEmail(final String email){
        // anas.abbal20@ump.ac.ma
        int lengthFirstName = 0;
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
    public static String getFirstNameFromEmailStudentCommand(final StudentCommand studentCommand){
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
    public static String getLastNameFromEmail(final String email, int lengthFirstName){
        // anas.abbal20@ump.ac.ma
        int count = 0;
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
    public Post addToStudent(final PostCommand postCommand){
        final Post post = Post.create(postCommand);

        post.linkToStudent(this);
        this.posts.add(post);
        return post;
    }
    public void linkToField(Field field){
        this.field = field;
    }
}
