package com.example.cicd.service;

import com.example.cicd.dto.GetPostDto;
import com.example.cicd.dto.WritePostDto;
import com.example.cicd.entity.Post;
import com.example.cicd.exception.NotFoundException;
import com.example.cicd.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void writePost(WritePostDto writePostDto) {
        postRepository.save(writePostDto.toEntity());
    }

    public List<GetPostDto> getPostList() {
        return postRepository.findAll().stream().map((post) -> GetPostDto.toDto(post)).toList();
    }

    public GetPostDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return GetPostDto.toDto(post);
    }
}
