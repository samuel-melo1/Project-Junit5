package br.com.samuel.apijunit5.config;

import br.com.samuel.apijunit5.domain.User;
import br.com.samuel.apijunit5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "samuel", "samuel@gmail.com", "1234");
        User u2 = new User(null, "sam", "sam@gmail.com", "1234");

        repository.saveAll(List.of(u1, u2));
    }
}
