package com.eureka.cooperfilme.repositories.userRepository;
import com.eureka.cooperfilme.domain.scripts.Scripts;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface ScriptRepository extends JpaRepository<Scripts, UUID> {
    List<Scripts> findByTitleContainingOrCustomerEmailContaining(String title, String email);
}
