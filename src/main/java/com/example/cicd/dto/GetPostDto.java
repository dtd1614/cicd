package com.example.cicd.dto;

import com.example.cicd.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetPostDto {
    private Long id;
    private String title;
    private String content;

    public static GetPostDto toDto(Post post){
        return GetPostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
