package com.example.springhw32.dto;

import com.example.springhw32.entity.Post;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private Post post;

    private String content;
}
