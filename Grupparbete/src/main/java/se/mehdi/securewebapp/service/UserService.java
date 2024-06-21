package se.mehdi.securewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.mehdi.securewebapp.entity.AppUser;
import se.mehdi.securewebapp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(AppUser userDto) {
        AppUser user = new AppUser();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(AppUser user) {
        userRepository.save(user);
    }

    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    public AppUser findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
}
}
