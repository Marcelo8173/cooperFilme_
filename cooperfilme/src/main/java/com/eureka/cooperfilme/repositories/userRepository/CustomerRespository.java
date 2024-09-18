package com.eureka.cooperfilme.repositories.userRepository;

import com.eureka.cooperfilme.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRespository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByEmail(String email);
}
