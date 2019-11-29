package com.hotel.demo.service;

import com.hotel.demo.model.Comment;

import java.util.Optional;

public interface CommentService {
    Iterable<Comment> findAll();

    Optional<Comment> findById(Long id);

    void save(Comment comment);

    void remove(Long id);

    Iterable<Comment> findCommentByHomeId(Long home_id);
}
