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

@Service
@RequiredArgsConstructor
@Slf4j
public class StLoUserService {

    private final StLoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // TODO : retrieve/ edit profile
    // TODO : List user
    // TODO : Change password (pas forgot, change)
    // TODO : Delete user
}
