package com.th3.openclass.model;

import com.th3.openclass.command.PostCommand;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "POSTS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Post extends BaseEntity{

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "post")
    private List<Vote> votes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;
    private Integer totalVotes = 0;

    public static Post create(final PostCommand postCommand){
        final Post post = new Post();

        post.content = postCommand.getContent();
        return post;
    }
    public void linkToStudent(Student student){
        this.student = student;
    }
}
