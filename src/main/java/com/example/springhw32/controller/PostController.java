package com.example.springhw32.controller;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 글 작성
    @PostMapping
    public PostDto createPost(@ModelAttribute PostDto postDto, Long userId) {
        return postService.createPost(postDto, userId);
    }

    // 최신순 글 조회
    @GetMapping
    public List<PostDto> finaAllByCreatedAtDesc() {
        return postService.finaAllByCreatedAtDesc();
    }

    // 작성자 글 조회
    @GetMapping("/{writer}")
    public List<PostDto> findAllByUsername(@PathVariable("writer") String username) {
        return postService.findAllByUsername(username);
    }

    // 댓글 많은 순 글 조회
    @GetMapping("/comments")
    public List<PostDto> findAllByOrderByCommentCountDesc() {
        return postService.findAllByOrderByCommentCountDesc();
    }
}
