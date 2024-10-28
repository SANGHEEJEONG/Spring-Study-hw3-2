package com.example.springhw32.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {

    private String title;

    private String content;

    private Long commentCount;

    private LocalDateTime createdAt;

}
