package com.hotel.demo.service.impl;

import com.hotel.demo.model.Comment;
import com.hotel.demo.repository.CommentRepository;
import com.hotel.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Iterable<Comment> findCommentByHomeId(Long home_id) {
        return commentRepository.findCommentByHomeId(home_id);
    }
}
