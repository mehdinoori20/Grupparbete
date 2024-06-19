//Den används av Spring Security för att ladda användardetaljer vid inloggning. När en användare försöker logga in med sitt användarnamn och lösenord, anropar Spring Security loadUserByUsername för att hämta användarens information från databasen.
//Den returnerade UserDetails-instansen används sedan av Spring Security för att verifiera användarens identitet och hantera inloggningsprocessen.
package se.mehdi.securewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.mehdi.securewebapp.entity.AppUser;
import se.mehdi.securewebapp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}

