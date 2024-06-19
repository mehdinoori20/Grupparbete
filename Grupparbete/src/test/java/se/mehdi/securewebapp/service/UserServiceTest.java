package se.mehdi.securewebapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.mehdi.securewebapp.entity.AppUser;
import se.mehdi.securewebapp.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser() {
        // Arrange
        AppUser user = new AppUser();
        user.setUsername("testuser");
        user.setPassword("password");

        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.save(any())).thenReturn(user);

        // Act
        AppUser registeredUser = userService.registerUser(user);

        // Assert
        assertNotNull(registeredUser);
        assertEquals("testuser", registeredUser.getUsername());
        assertEquals("encodedPassword", registeredUser.getPassword());
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void deleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        userService.deleteUser(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void updateUserPassword_UserExists() {
        // Arrange
        String username = "testuser";
        String newPassword = "newPassword";
        AppUser existingUser = new AppUser();
        existingUser.setUsername(username);
        existingUser.setPassword("oldPassword");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(existingUser));
        when(passwordEncoder.encode(newPassword)).thenReturn("encodedNewPassword");
        when(userRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        AppUser updatedUser = userService.updateUserPassword(username, newPassword);

        // Assert
        assertNotNull(updatedUser);
        assertEquals("testuser", updatedUser.getUsername());
        assertEquals("encodedNewPassword", updatedUser.getPassword());
        verify(userRepository, times(1)).findByUsername(username);
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    void updateUserPassword_UserNotFound() {
        // Arrange
        String username = "nonExistingUser";
        String newPassword = "newPassword";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            userService.updateUserPassword(username, newPassword);
        });
    }

    @Test
    void findAllUsers() {
        // Arrange
        List<AppUser> users = Arrays.asList(new AppUser(), new AppUser());
        when(userRepository.findAll()).thenReturn(users);

        // Act
        List<AppUser> foundUsers = userService.findAllUsers();

        // Assert
        assertNotNull(foundUsers);
        assertEquals(2, foundUsers.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void findUserById_UserExists() {
        // Arrange
        Long userId = 1L;
        AppUser user = new AppUser();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        AppUser foundUser = userService.findUserById(userId);

        // Assert
        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getId());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void findUserById_UserNotFound() {
        // Arrange
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        AppUser foundUser = userService.findUserById(userId);

        // Assert
        assertNull(foundUser);
        verify(userRepository, times(1)).findById(userId);
    }
}
