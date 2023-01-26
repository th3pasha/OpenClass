package com.th3.openclass.dto.mapper;


import com.th3.openclass.dto.PostDto;
import com.th3.openclass.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toDto(Post post);
}
