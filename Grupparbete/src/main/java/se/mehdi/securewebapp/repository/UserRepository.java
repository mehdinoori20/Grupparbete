package se.mehdi.securewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mehdi.securewebapp.entity.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
