package com.th3.openclass.service.post;


import com.th3.openclass.command.PostCommand;
import com.th3.openclass.model.Post;

public interface PostService {
    Post create(final String studentId, final PostCommand postCommand);
}
