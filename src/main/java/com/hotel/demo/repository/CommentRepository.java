package com.hotel.demo.repository;

import com.hotel.demo.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findCommentByHomeId(Long home_id);
}
