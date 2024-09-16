package com.eureka.cooperfilme.dataBase.seeds;

import com.eureka.cooperfilme.domain.customer.Customer;
import com.eureka.cooperfilme.domain.scripts.Scripts;
import com.eureka.cooperfilme.domain.scripts.enuns.ScriptsStatus;
import com.eureka.cooperfilme.domain.user.User;
import com.eureka.cooperfilme.domain.user.enuns.UserRoles;
import com.eureka.cooperfilme.repositories.userRepository.CustomerRespository;
import com.eureka.cooperfilme.repositories.userRepository.ScriptRepository;
import com.eureka.cooperfilme.repositories.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Seeds implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    private PasswordEncoder encoder;

    @Autowired
    private ScriptRepository scriptRepository;

    @Autowired
    private CustomerRespository customerRespository;

    public Seeds(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User u1 = new User(null, "analista", "analista@gmail.com", "analista", UserRoles.ANALISTA);
            User u2 = new User(null, "revisor", "revisor@gmail.com", "revisor", UserRoles.REVISOR);
            User u3 = new User(null, "aprovadores1", "aprovadores1@gmail.com", "aprovadores1", UserRoles.APROVADORES);
            User u4 = new User(null, "aprovadores2", "aprovadores2@gmail.com", "aprovadores2", UserRoles.APROVADORES);
            User u5 = new User(null, "aprovadores3", "aprovadores3@gmail.com", "aprovadores3", UserRoles.APROVADORES);

            u1.setPassword(encoder.encode(u1.getPassword()));
            u2.setPassword(encoder.encode(u2.getPassword()));
            u3.setPassword(encoder.encode(u3.getPassword()));
            u4.setPassword(encoder.encode(u4.getPassword()));
            u5.setPassword(encoder.encode(u5.getPassword()));

            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

            Customer customer = new Customer(null, "Produtor", "produtor@gmail.com", "11993882395");
            customerRespository.save(customer);
            Scripts scripts1 = new Scripts(null
                    , "Sully: O Herói do Rio Hudson", "Em 2009, o mundo ficou em estado de choque quando o Capitão Chesley \"Sully\" Sullenberger conseguiu pousar um avião em pane no rio Hudson. A manobra quase impossível salvou a vida dos 150 passageiros e alçou Sully à categoria de herói nacional. No entanto, nem mesmo a aclamação pública foi capaz de impedir uma investigação rigorosa sobre sua reputação e carreira."
                    , customer
                    , ScriptsStatus.EM_ANALISE);
            Scripts scripts2 = new Scripts(null
                    , "Uma Longa Jornada",
                    "A história de amor de Luke, um ex campeão de rodeios, e Sophia, uma estudante universitária que está prestes a embarcar em seu emprego dos sonhos. Com caminhos conflitantes testando o seu relacionamento, suas vidas cruzam com a de um senhor mais velho, cujas memórias inspiram profundamente o jovem casal."
                    , customer
                    , ScriptsStatus.EM_ANALISE);

            Scripts scripts3 = new Scripts(null
                    , "Imaculada",
                    "Cecilia, uma jovem religiosa, se torna freira em um convento isolado na região rural italiana. Após uma gravidez misteriosa, Cecilia é atormentada por forças perversas, enquanto confronta segredos sombrios e horrores do convento."
                    , customer
                    , ScriptsStatus.AGUARDANDO_APROVACAO);

            scriptRepository.saveAll(Arrays.asList(scripts1, scripts2, scripts3));

        }
    }
}
