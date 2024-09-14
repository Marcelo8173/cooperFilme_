package com.eureka.cooperfilme.controllers;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;
import com.eureka.cooperfilme.services.useCases.CreateScriptService;
import com.eureka.cooperfilme.services.useCases.ListScriptsBySearchService;
import com.eureka.cooperfilme.services.useCases.ScriptCheckDetails;
import com.eureka.cooperfilme.services.useCases.ScriptsListAll;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eureka.cooperfilme.domain.scripts.scriptsDTO.CreateSriptDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.net.URLDecoder;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/scripts")
public class ScriptsController {
    @Autowired
    CreateScriptService scriptService;

    @Autowired
    ListScriptsBySearchService listScriptsBySearchService;

    @Autowired
    ScriptCheckDetails scriptCheckDetails;

    @Autowired
    ScriptsListAll scriptsListAll;

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
    public ResponseEntity<List<String>> listScripts(@RequestParam(value = "search", defaultValue = "") String search) {
        search = URLDecoder.decode(search);
        if (search.trim().isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList());
        }
        List<Scripts> scripts = listScriptsBySearchService.listScripts(search, search);

        List<String> scriptStauts = scripts.stream()
                .map(script -> script.getStatus().name())
                .toList();
        return ResponseEntity.ok().body(scriptStauts);
    }

    @GetMapping("/check/details/{id}")
    public ResponseEntity<Scripts> checkDetailsOnScript(@PathVariable UUID id) {
        var response = scriptCheckDetails.listDetailsOnScript(id)
                .map(script -> ResponseEntity.ok(script))
                .orElseGet(() -> ResponseEntity.notFound().build());
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Scripts>> listAll(@RequestParam(value = "status", required = false) ScriptsStatus status,
                                                 @RequestParam(value = "sendDate", required = false)
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate sendDate,
                                                 @RequestParam(value = "email", required = false) String email) {
        return ResponseEntity.ok().body(scriptsListAll.listAllScripts(status, sendDate, email));
    }

}
