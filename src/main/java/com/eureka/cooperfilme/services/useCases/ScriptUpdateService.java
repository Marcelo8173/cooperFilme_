package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ScriptUpdateService {
    @Autowired
    private ScriptRepository scriptRepository;

    public void updateScriptStatus(UUID id, String newStatus) {
        Optional<Scripts> optionalScript = scriptRepository.findById(id);
        if (optionalScript.isPresent()) {
            Scripts script = optionalScript.get();
            script.setStatus(ScriptsStatus.valueOf(newStatus));
            scriptRepository.save(script);
        } else {
            throw new RuntimeException("Script not found");
        }
    }
}
