package com.eureka.cooperfilme.services.useCases;

import com.eureka.cooperfilme.domain.customer.Customer;
import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;
import com.eureka.cooperfilme.domain.scripts.scriptsDTO.CreateSriptDTO;
import com.eureka.cooperfilme.repositories.userRepository.CustomerRespository;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateScriptService {
    @Autowired
    ScriptRepository scriptRepository;

    @Autowired
    CustomerRespository customerRespository;

    public Scripts createScript(CreateSriptDTO createSriptDTO) {
        Customer cliente = customerRespository.findByEmail(createSriptDTO.email())
                .orElseGet(() -> createNewCustomer(createSriptDTO));

        Scripts script = new Scripts(null, createSriptDTO.title(), createSriptDTO.content(), cliente, ScriptsStatus.EM_ANALISE);
        return scriptRepository.save(script);
    }


    private Customer createNewCustomer(CreateSriptDTO createSriptDTO) {
        Customer customer = new Customer(null, createSriptDTO.name(), createSriptDTO.email(), createSriptDTO.phone());
        return customerRespository.save(customer);
    }

}
