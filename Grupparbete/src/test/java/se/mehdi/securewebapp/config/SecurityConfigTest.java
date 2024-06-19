package se.mehdi.securewebapp.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void securityFilterChain() {
        SecurityFilterChain securityFilterChain = context.getBean(SecurityFilterChain.class);
        assertNotNull(securityFilterChain, "SecurityFilterChain bean should not be null");
    }

    @Test
    void passwordEncoder() {
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        assertNotNull(passwordEncoder, "PasswordEncoder bean should not be null");
        assertTrue(passwordEncoder.encode("test").matches("\\$2[ayb]\\$.{56}"), "Encoded password should match BCrypt pattern");
    }

    @Test
    void webSecurityCustomizer() {
        WebSecurityCustomizer webSecurityCustomizer = context.getBean(WebSecurityCustomizer.class);
        assertNotNull(webSecurityCustomizer, "WebSecurityCustomizer bean should not be null");
    }
}
