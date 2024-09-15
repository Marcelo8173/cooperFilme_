package com.eureka.cooperfilme.repositories.userRepository;

import com.eureka.cooperfilme.domain.comment.Comment;
import com.eureka.cooperfilme.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByScriptId(UUID scriptId);
}