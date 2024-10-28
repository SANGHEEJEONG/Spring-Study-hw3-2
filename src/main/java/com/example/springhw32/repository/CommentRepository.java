package com.example.springhw32.repository;

import com.example.springhw32.entity.Comment;
import com.example.springhw32.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPost_PostId(Long postId);
}
