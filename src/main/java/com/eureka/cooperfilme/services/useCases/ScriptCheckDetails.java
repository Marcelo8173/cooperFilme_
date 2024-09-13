package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ScriptCheckDetails {
    @Autowired
    ScriptRepository scriptRepository;

    public Optional<Scripts> listDetailsOnScript (UUID uuid) {
        return scriptRepository.findById(uuid);
    }
}
