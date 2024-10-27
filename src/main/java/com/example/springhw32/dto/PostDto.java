package com.example.springhw32.dto;

import com.example.springhw32.entity.User;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {

    private User user;

    private String title;

    private String content;

    private Long commentCount;

    private LocalDateTime createdAt;

}
