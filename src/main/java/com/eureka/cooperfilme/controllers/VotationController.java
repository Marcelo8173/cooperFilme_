package com.eureka.cooperfilme.controllers;

import com.eureka.cooperfilme.domain.votation.quantityDTO.VotationQuantityDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import com.eureka.cooperfilme.services.useCases.ComputeVotes;

@RestController
@RequestMapping(value = "/votation")
public class VotationController {

    @Autowired
    ComputeVotes computeVotes;

    @PostMapping("/{id}/{userId}")
    public ResponseEntity<VotationQuantityDTO> createVotation(@PathVariable UUID id, @PathVariable UUID userId) throws BadRequestException {
        System.out.println(userId);
        Integer votation = computeVotes.computeVote(id, userId);
        return ResponseEntity.ok().body(new VotationQuantityDTO(votation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VotationQuantityDTO> listAllVotes(@PathVariable UUID id) {
        Integer votation = computeVotes.listAllVotes(id);
        return ResponseEntity.ok().body(new VotationQuantityDTO(votation));
    }
}
