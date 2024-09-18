package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScriptsListAll {
    @Autowired
    ScriptRepository scriptRepository;

    public List<Scripts> listAllScripts(ScriptsStatus status, LocalDate sendDate, String email) {
        Specification<Scripts> spec = Specification.where(null);
        if (status != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("status"), status));
        }

        if (sendDate != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), sendDate));
        }

        if (email != null && !email.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("customer").get("email"), email));
        }

        return scriptRepository.findAll(spec);
    }
}
