package com.example.pidevthecreators.repositories;

import com.example.pidevthecreators.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}