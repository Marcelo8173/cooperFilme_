package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.comment.Comment;
import com.eureka.cooperfilme.repositories.userRepository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentsListAll {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> listAll (UUID id) {
        return commentRepository.findByScriptId(id);
    }
}
