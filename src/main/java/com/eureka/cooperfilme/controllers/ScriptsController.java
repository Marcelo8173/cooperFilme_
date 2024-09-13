package com.eureka.cooperfilme.controllers;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.services.useCases.CreateScriptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eureka.cooperfilme.domain.scripts.scriptsDTO.CreateSriptDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/scripts")
public class ScriptsController {
    @Autowired
    CreateScriptService scriptService;

    @PostMapping
    public ResponseEntity<CreateSriptDTO> createScript(@RequestBody @Valid CreateSriptDTO createSriptDTO) {
        Scripts scrpitSaved = scriptService.createScript(createSriptDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(scrpitSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateSriptDTO(scrpitSaved.getTitle(),
                    scrpitSaved.getContent(),
                    scrpitSaved.getClient().getName(),
                    scrpitSaved.getClient().getEmail(),
                    scrpitSaved.getClient().getPhone()));
    }
}
