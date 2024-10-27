package com.example.springhw32.controller;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/posts/comments")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public CommentDto createComment(@ModelAttribute CommentDto commentDto, @RequestParam Long postId) {
        return commentService.createComment(commentDto, postId);
    }

    // 특정 게시물에 달린 모든 댓글 조회
    @GetMapping("/{postId}")
    public List<CommentDto> findAllByPostId(@PathVariable Long postId) {
        return commentService.findAllByPostId(postId);
    }
}
