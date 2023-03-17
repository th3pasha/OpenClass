package com.th3.openclass.dto.mapper;


import com.th3.openclass.dto.PostDto;
import com.th3.openclass.dto.StudentDto;
import com.th3.openclass.model.Post;
import com.th3.openclass.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toDto(Post post);
}
