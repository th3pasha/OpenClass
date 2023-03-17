package com.th3.openclass.dto;


import com.th3.openclass.model.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDto
{
    private String id;
    private String content;
    private List<VoteDto> votes;
    private Integer totalVotes;
}
