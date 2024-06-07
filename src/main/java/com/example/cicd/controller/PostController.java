package com.example.cicd.controller;

import com.example.cicd.dto.GetPostDto;
import com.example.cicd.dto.WritePostDto;
import com.example.cicd.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity writePost(@RequestBody WritePostDto writePostDto){
        postService.writePost(writePostDto);
        return ResponseEntity.status(201).body("SUCCESS");
    }

    @GetMapping
    public ResponseEntity<List<GetPostDto>> getPostList(){
        return ResponseEntity.ok(postService.getPostList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPostDto> getPost(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPost(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.ok("SUCCESS");
    }
}
