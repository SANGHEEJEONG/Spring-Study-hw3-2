package com.example.springhw32.repository;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.entity.Post;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByOrderByCreatedAtDesc();
    List<Post> findAllByUser_Username(String username);
    List<Post> findAllByOrderByCommentCountDesc();
}
