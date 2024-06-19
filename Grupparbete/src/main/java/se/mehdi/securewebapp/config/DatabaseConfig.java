package se.mehdi.securewebapp.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import se.mehdi.securewebapp.repository.UserRepository;


@Configuration
public class DatabaseConfig {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("DatabaseConfig initialized with UserRepository: " + userRepository);
        // Här kan du eventuellt göra något annat som behöver göras vid uppstart
    }
}
