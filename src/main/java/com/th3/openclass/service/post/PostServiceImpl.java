package com.th3.openclass.service.post;


import com.th3.openclass.command.PostCommand;
import com.th3.openclass.exception.BusinessException;
import com.th3.openclass.exception.ExceptionPayloadFactory;
import com.th3.openclass.model.Post;
import com.th3.openclass.model.Student;
import com.th3.openclass.repository.PostRepository;
import com.th3.openclass.repository.StudentRepository;
import com.th3.openclass.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final StudentRepository studentRepository;

    @Override
    public Post create(String studentId, PostCommand postCommand) {
        log.info("Begin fetching student with id {}", studentId);
        final Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.STUDENT_NOT_FOUND.get())
        );
        log.info("Begin add post with payload {} from student with id {}", JSONUtil.toJSON(postCommand) ,studentId);
        final Post post = student.addToStudent(postCommand);
        postRepository.save(post);
        return post;
    }

    @Override
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }


}
