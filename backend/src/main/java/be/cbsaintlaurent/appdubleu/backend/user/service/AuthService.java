package be.cbsaintlaurent.appdubleu.backend.user.service;

import be.cbsaintlaurent.appdubleu.backend.user.dto.LoginRequest;
import be.cbsaintlaurent.appdubleu.backend.user.dto.RegisterRequest;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final StLoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public String login(String username, String password) {
        Optional<StLoUserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return null; // User not found
        }
        if(!user.get().isEnabled()){
            return null; // User disabled/ banned
        }
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            return null; // Password incorrect
        }

        StLoUserEntity u = user.get();
        return jwtService.generateToken(
                u.getId().toString(),
                u.getFirstname() + " " + u.getLastname(),
                u.getRole() == StLoRole.ADMIN
        );
    }

    @Transactional
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    public ResponseEntity<LoginRequest> register(RegisterRequest request) {
        StLoUserEntity user = new StLoUserEntity();
        String username = request.getFirstname().toLowerCase() + "."  + request.getLastname().toLowerCase();
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

