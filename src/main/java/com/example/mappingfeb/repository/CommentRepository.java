package com.example.mappingfeb.repository;

import com.example.mappingfeb.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}