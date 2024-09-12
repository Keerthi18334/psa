package com.example.mappingfeb.controller;

import com.example.mappingfeb.entity.Comment;
import com.example.mappingfeb.entity.Post;
import com.example.mappingfeb.repository.CommentRepository;
import com.example.mappingfeb.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @PostMapping
    public ResponseEntity<Comment> createComment(
            @RequestBody Comment comment,
            @RequestParam long postId

    ) {
         Post post=postRepository.findById(postId).get();
         comment.setPost(post);
         return ResponseEntity.ok(commentRepository.save(comment));
    }
}
