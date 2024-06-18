package se.mehdi.securewebapp.config;

import jakarta.annotation.PostConstruct;
import se.mehdi.securewebapp.repository.UserRepository;

public class DatabaseConfig {
    private UserRepository userRepository;

    public DatabaseConfig(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @PostConstruct
    public void init() {
        // Här kan du skriva kod som behöver köras vid initiering
        System.out.println("DatabaseConfig initialized with UserRepository: " + userRepository);
    }

}

