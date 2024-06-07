package com.example.cicd.dto;

import com.example.cicd.entity.Post;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WritePostDto {
    private String title;
    private String content;

    public Post toEntity(){
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
