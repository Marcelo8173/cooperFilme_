package com.eureka.cooperfilme.dataBase.seeds;

import com.eureka.cooperfilme.domain.user.User;
import com.eureka.cooperfilme.domain.user.enuns.UserRoles;
import com.eureka.cooperfilme.repositories.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Seeds  implements CommandLineRunner {
    private PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

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

        }
    }
}
