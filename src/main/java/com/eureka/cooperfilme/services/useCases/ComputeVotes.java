package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;
import com.eureka.cooperfilme.domain.votation.Votation;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import com.eureka.cooperfilme.repositories.userRepository.VotationRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComputeVotes {

    @Autowired
    VotationRepository votationRepository;

    @Autowired
    ScriptRepository scriptRepository;

    public Integer computeVote(UUID id, UUID userId) throws BadRequestException {
        Scripts scripts = scriptRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Script not found"));

        if (!scripts.getStatus().equals(ScriptsStatus.AGUARDANDO_APROVACAO)) {
            throw new BadRequestException("This script is not waiting aprovation");
        }

        Optional<Votation> existingVote = votationRepository.findByScriptIdAndUserId(id, userId);
        if (existingVote.isPresent()) {
            throw new BadRequestException("User has already voted");
        }

        List<Votation> votations = votationRepository.findByScriptId(id);
        int totalVotes = votations.stream().mapToInt(Votation::getQuantity).sum();

        if (totalVotes >= 3) {
            throw new BadRequestException("Maximum number of votes reached for this script");
        }



        Votation newVote = new Votation(null, 1, id, userId);
        votationRepository.save(newVote);

        totalVotes += newVote.getQuantity();

        if (totalVotes == 3) {
            scripts.setStatus(ScriptsStatus.APROVADO);
            scriptRepository.save(scripts);
        }

        return totalVotes;
    }

    public Integer listAllVotes(UUID id) {
        List<Votation> votations = votationRepository.findByScriptId(id);
        int totalVotes = votations.stream().mapToInt(Votation::getQuantity).sum();
        return totalVotes;
    }
}
