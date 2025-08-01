package be.cbsaintlaurent.appdubleu.backend.user.service;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StLoUserService {

    private final StLoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // pour encoder les mots de passe

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public StLoUser createUser(String username, String firstName, String lastName, String email, String password, StLoRole role) {
        StLoUser user = new StLoUser();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(true);
        user.setDateInscription(LocalDate.now());
        return userRepository.save(user);
    }
}

