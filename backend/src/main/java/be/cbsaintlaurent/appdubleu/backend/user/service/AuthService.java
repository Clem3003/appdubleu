package be.cbsaintlaurent.appdubleu.backend.user.service;

import be.cbsaintlaurent.appdubleu.backend.user.dto.LoginRequest;
import be.cbsaintlaurent.appdubleu.backend.user.dto.RegisterRequest;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.exception.BadCredentialsException;
import be.cbsaintlaurent.appdubleu.backend.user.exception.UserDisabledException;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final StLoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public String login(String username, String password) {
        StLoUserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        if (!user.isEnabled()) {
            throw new UserDisabledException("User account is disabled");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return jwtService.generateToken(
                user.getUsername(),
                user.getId().toString(),
                user.getRole() == StLoRole.ADMIN
        );
    }

    @Transactional
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public ResponseEntity<?> register(RegisterRequest request) {
        // Vérification que tous les champs nécessaires sont remplis
        if (request.getFirstname() == null || request.getLastname() == null ||
                request.getEmail() == null || request.getPassword() == null ||
                request.getDateOfBirth() == null) {
            return ResponseEntity.badRequest().body("Tous les champs requis doivent être remplis.");
        }
        String username = request.getFirstname().toLowerCase() + "." + request.getLastname().toLowerCase();

        // Vérification de l’unicité de l’email
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Un utilisateur avec cet email existe déjà.");
        }

        // Vérification de l’unicité du username
        if (userRepository.existsByUsername(username)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Un utilisateur avec ce nom d'utilisateur existe déjà.");
        }

        StLoUserEntity user = new StLoUserEntity();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(username);
        user.setNickname(request.getNickname());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setEmail(request.getEmail());
        user.setRole(StLoRole.ADMIN); // TODO : SET TO ROLE USER FOR PROD !!!
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.setRegisterDate(LocalDate.now());
        userRepository.save(user);
        return ResponseEntity.ok(new LoginRequest(username, ""));
    }

    // TODO : Refresh JWT
    // TODO : Forgot password
}

