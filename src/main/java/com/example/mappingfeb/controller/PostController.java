package com.example.mappingfeb.controller;

import com.example.mappingfeb.entity.Post;
import com.example.mappingfeb.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //http://localhost:8080/api/v1/posts

    @PostMapping("/create")
    public ResponseEntity<Post>createPost(@RequestBody Post post) {
        Post savedPost=postRepository.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
}