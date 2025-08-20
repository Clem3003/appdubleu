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
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {
//        StLoUserEntity user = authService.authenticate(request.username(), request.password());
//        authService.setAuthentication(user, httpRequest);
//        return ResponseEntity.ok(Map.of("message", "Login successful"));
//    }
    @PostMapping("/login")
    public ResponseEntity<StLoUser> login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {
        StLoUserEntity user = authService.authenticate(request.username(), request.password());
        authService.setAuthentication(user, httpRequest);

        return ResponseEntity.ok(authService.getCurrentUser());
    }

//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request) {
//        authService.clearAuthentication(request);
//        return ResponseEntity.ok(Map.of("message", "Logout successful"));
//    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest httpRequest) {
        System.out.println("logout");
        authService.clearAuthentication(httpRequest);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/me")
//    public ResponseEntity<?> me() {
//        StLoUser currentUser = authService.getCurrentUser();
//        if (currentUser == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authenticated");
//        }
//        return ResponseEntity.ok(currentUser);
//    }

    @GetMapping("/me")
    public ResponseEntity<StLoUser> me() {
        StLoUser user = authService.getCurrentUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return authService.register(request);
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

