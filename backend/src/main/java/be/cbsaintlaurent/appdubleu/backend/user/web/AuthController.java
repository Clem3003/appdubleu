package be.cbsaintlaurent.appdubleu.backend.user.web;

import be.cbsaintlaurent.appdubleu.backend.user.dto.LoginRequest;
import be.cbsaintlaurent.appdubleu.backend.user.dto.RegisterRequest;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.exception.BadCredentialsException;
import be.cbsaintlaurent.appdubleu.backend.user.exception.UserDisabledException;
import be.cbsaintlaurent.appdubleu.backend.user.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {
        System.out.println("login");
        StLoUserEntity user = authService.login(request.username(), request.password());
        System.out.println("login auth service worked");

        // ✅ Crée un Authentication pour Spring Security
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        List.of(() -> user.getRole().name()) // autorité = rôle
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // ✅ Force la création de session -> cookie JSESSIONID
        httpRequest.getSession(true)
                .setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                        SecurityContextHolder.getContext());

        return ResponseEntity.ok(user); // tu peux renvoyer un DTO avec id/username/role
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logout success");
    }

    @GetMapping("/me")
    public ResponseEntity<?> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body("Not authenticated");
        }

        // Ici on suppose que le principal est le username (String)
        String username = authentication.getName();
        String role = authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .findFirst()
                .orElse("");

        StLoUser stLoUser = new StLoUser();
        stLoUser.setUsername(username);
        stLoUser.setRole(StLoRole.ADMIN);
        return ResponseEntity.ok(stLoUser);
    }


    public record LoginRequest(String username, String password) {}
}
//public class AuthController {
//
//    private final AuthService service;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        try {
//            String token = service.login(request.getUsername(), request.getPassword());
//            System.out.println("login ok");
//            return ResponseEntity.ok(new JwtResponse(token));
//        } catch (BadCredentialsException e) {
//            System.out.println("login fail: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//        } catch (UserDisabledException e) {
//            System.out.println("login fail: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
//        return service.register(request);
//    }
//
//    @Getter
//    @AllArgsConstructor
//    public static class JwtResponse {
//        private String token;
//    }
//
//    @GetMapping("/version")
//    public String getVersion() {
//        return "Demo v0.0.1";
//    }
//
//    // TODO : to be removed, testing purposes
//    @PostMapping("/ping")
//    public String ping() {
//        return "pong";
//    }
//
//    // TODO : to be removed, testing purposes
//    @PostMapping("/secured_ping")
//    public String securedPing() {
//        System.out.println("secured-pong");
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Current Authentication: " + auth);
//        System.out.println("isAuthenticated: " + auth.isAuthenticated());
//        return "secured pong";
//    }
//
//    // TODO : to be removed, testing purposes
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/secured_ping_admin")
//    public String securedPingAdmin() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Current Authentication: " + auth);
//        System.out.println("isAuthenticated: " + auth.isAuthenticated());
//        System.out.println("isAdmin");
//        return "secured admin pong";
//    }
//}

