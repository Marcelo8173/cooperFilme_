package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListScriptsBySearchService {
    @Autowired
    ScriptRepository scriptRepository;

    public List<Scripts> listScripts (String title, String email) {
        return scriptRepository.findByTitleContainingOrCustomerEmailContaining(title, email);

    }
}
