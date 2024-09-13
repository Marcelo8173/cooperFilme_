package com.eureka.cooperfilme.controllers;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.services.useCases.CreateScriptService;
import com.eureka.cooperfilme.services.useCases.ListScriptsBySearchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eureka.cooperfilme.domain.scripts.scriptsDTO.CreateSriptDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.net.URLDecoder;

@RestController
@RequestMapping(value = "/scripts")
public class ScriptsController {
    @Autowired
    CreateScriptService scriptService;

    @Autowired
    ListScriptsBySearchService listScriptsBySearchService;

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

    @GetMapping("/check")
    public ResponseEntity<List<Scripts>> listScripts(@RequestParam(value = "search", defaultValue = "") String search) {
        search =  URLDecoder.decode(search);
        if (search.trim().isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList());
        }
        List<Scripts> scripts = listScriptsBySearchService.listScripts(search, search);
        return ResponseEntity.ok().body(scripts);
    }

}
