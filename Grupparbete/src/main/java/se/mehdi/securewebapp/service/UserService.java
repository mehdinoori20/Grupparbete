package se.mehdi.securewebapp.service;

//Mehdi
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.mehdi.securewebapp.entity.AppUser;
import se.mehdi.securewebapp.entity.Role;
import se.mehdi.securewebapp.repository.RoleRepository;
import se.mehdi.securewebapp.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppUser registerUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public AppUser updateUser(AppUser user) {
        return userRepository.save(user);
    }

    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
