package com.th3.openclass.service.post;


import com.th3.openclass.command.PostCommand;
import com.th3.openclass.model.Post;
import org.springframework.data.domain.Page;
import com.th3.openclass.command.PostCommand;
import org.springframework.data.domain.Pageable;


public interface PostService
{
    Post create(final String studentId, final PostCommand postCommand);
    Page<Post> getPosts(Pageable pageable);

}
