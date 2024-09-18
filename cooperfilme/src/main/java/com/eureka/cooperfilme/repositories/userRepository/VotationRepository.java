package com.eureka.cooperfilme.repositories.userRepository;

import com.eureka.cooperfilme.domain.votation.Votation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VotationRepository extends JpaRepository<Votation, UUID> {
    Optional<Votation> findByUserId(UUID id);
    Optional<Votation> findByScriptIdAndUserId(UUID scriptId, UUID userId);
    List<Votation> findByScriptId(UUID scriptId);
}

