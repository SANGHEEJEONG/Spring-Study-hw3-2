package com.example.springhw32.service;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.entity.Post;
import com.example.springhw32.entity.User;
import com.example.springhw32.repository.PostRepository;
import com.example.springhw32.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDto createPost(PostDto postDto, Long userId){
        User user = userRepository.findById(userId).orElseThrow();

        Post post = new Post();
        post.setUser(user);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);

        return postDto;
    }

    public List<PostDto> finaAllByCreatedAtDesc(){
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(this::convertToPostDto)
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllByUsername(String username) {
        return postRepository.findAllByUser_Username(username).stream()
                .map(this::convertToPostDto)
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllByOrderByCommentCountDesc() {
        return postRepository.findAllByOrderByCommentCountDesc().stream()
                .map(this::convertToPostDto)
                .collect(Collectors.toList());
    }

    public PostDto convertToPostDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setUser(post.getUser());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setCreatedAt(post.getCreatedAt());

        return postDto;
    }

}
