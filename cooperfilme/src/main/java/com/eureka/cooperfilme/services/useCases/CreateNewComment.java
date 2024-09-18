package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.comment.Comment;
import com.eureka.cooperfilme.domain.comment.commentDTO.CommentDTO;
import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.repositories.userRepository.CommentRepository;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import org.hibernate.validator.spi.scripting.ScriptEvaluatorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateNewComment {
    @Autowired
    ScriptRepository scriptRepository;
    
    @Autowired
    CommentRepository commentRepository;
    
    public Comment createNewComment(UUID id, @RequestBody CommentDTO comment) {
        Optional<Scripts> scriptOptional = scriptRepository.findById(id);
        if (scriptOptional.isEmpty()) {
            throw new ScriptEvaluatorNotFoundException();
        }
        Scripts script = scriptOptional.get();
        System.out.println(script);
        Comment newComment = new Comment(null, comment.comment(), script.getId(), script.getClient().getId() );

        return commentRepository.save(newComment);
    }
}
