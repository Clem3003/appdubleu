package be.cbsaintlaurent.appdubleu.backend.user.service;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StLoUserService {

    private final StLoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // pour encoder les mots de passe
    private final JwtService jwtService;

    @Transactional
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
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

    @Transactional
    public StLoUser login(String username, String password) {
        Optional<StLoUser> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return null; // User not found
        }
        if(!user.get().isEnabled()){
            return null; // User disabled/ banned
        }
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            return null; // Password incorrect
        }
        return user.get();
    }

    @Transactional
    public String loginAndGetToken(String username, String password) {
        Optional<StLoUser> user = userRepository.findByUsername(username);
        if (user.isEmpty() || !user.get().isEnabled()) {
            return null;
        }
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            return null;
        }

        StLoUser u = user.get();
        return jwtService.generateToken(
                u.getId().toString(), // sub
                u.getFirstName() + " " + u.getLastName(), // name
                u.getRole() == StLoRole.ADMIN // admin
        );
    }
}

