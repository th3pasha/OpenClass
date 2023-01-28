package com.th3.openclass.controller;


import com.th3.openclass.command.PostCommand;
import com.th3.openclass.dto.PostDto;
import com.th3.openclass.dto.mapper.PostMapper;
import com.th3.openclass.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.th3.openclass.constants.ResourcePath.POSTS;
import static com.th3.openclass.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + POSTS)
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    @PostMapping("/{studentId}/")
    @PreAuthorize("hasRole('ADMIN') or #studentId == authentication.principal.studentId")
    public ResponseEntity<PostDto> createPost(@PathVariable("studentId") final String studentId,
                                              @RequestBody final PostCommand postCommand){
        return ResponseEntity.ok(postMapper.toDto(postService.create(studentId, postCommand)));
    }
}
