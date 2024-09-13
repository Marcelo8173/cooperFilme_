package com.eureka.cooperfilme.repositories.userRepository;
import com.eureka.cooperfilme.domain.scripts.Scripts;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ScriptRepository extends JpaRepository<Scripts, UUID> {
}
