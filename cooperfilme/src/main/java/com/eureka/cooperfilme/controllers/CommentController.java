package com.eureka.cooperfilme.controllers;

import com.eureka.cooperfilme.domain.comment.Comment;
import com.eureka.cooperfilme.domain.comment.commentDTO.CommentDTO;
import com.eureka.cooperfilme.services.useCases.CommentsListAll;
import com.eureka.cooperfilme.services.useCases.CreateNewComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CreateNewComment createNewComment;

    @Autowired
    CommentsListAll commentsListAll;

    @PostMapping("/script/{id}")
    public ResponseEntity<Comment> createNewComment (@PathVariable UUID id, @RequestBody CommentDTO comment) {
        var newComent = createNewComment.createNewComment(id, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComent);
    }

    @GetMapping("/script/{id}")
    public ResponseEntity<List<Comment>> listAllComents (@PathVariable UUID id) {
        var newComent = commentsListAll.listAll(id);
        return ResponseEntity.ok().body(newComent);
    }
}
