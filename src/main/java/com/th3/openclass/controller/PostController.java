package com.th3.openclass.controller;


import com.th3.openclass.command.PostCommand;
import com.th3.openclass.dto.PostDto;
import com.th3.openclass.dto.mapper.PostMapper;
import com.th3.openclass.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.th3.openclass.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + AUTH + POSTS)
@CrossOrigin("*")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    @PostMapping("/{studentId}/")
    public ResponseEntity<PostDto> createPost(@PathVariable("studentId") final String studentId,
                                              @RequestBody final PostCommand postCommand)
    {
        return ResponseEntity.ok(postMapper.toDto(postService.create(studentId, postCommand)));
    }
    @GetMapping()
    public ResponseEntity<Page<PostDto>> getStudents(Pageable pageable){
        return ResponseEntity.ok(postService.getPosts(pageable).map(postMapper::toDto));
    }
}
