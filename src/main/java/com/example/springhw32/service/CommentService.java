package com.example.springhw32.service;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.entity.Comment;
import com.example.springhw32.entity.Post;
import com.example.springhw32.repository.CommentRepository;
import com.example.springhw32.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentDto createComment(CommentDto commentDto, Long postId){
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);
        commentRepository.save(comment);

        // 댓글 수 증가
        post.setCommentCount(post.getCommentCount() + 1L);
        postRepository.save(post);

        return commentDto;
    }

    public List<CommentDto> findAllByPostId(Long postId){
        return commentRepository.findAllByPost_PostId(postId).stream()
                .map(this::convertToCommentDto)
                .collect(Collectors.toList());
    }


    public CommentDto convertToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();

        commentDto.setContent(comment.getContent());

        return commentDto;
    }
}
