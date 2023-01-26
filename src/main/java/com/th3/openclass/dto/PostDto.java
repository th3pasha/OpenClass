package com.th3.openclass.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDto {
    private String id;
    private List<VoteDto> votes;
    private Integer totalVotes;
}
