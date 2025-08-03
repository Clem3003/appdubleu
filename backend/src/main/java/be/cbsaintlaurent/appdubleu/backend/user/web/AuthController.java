package be.cbsaintlaurent.appdubleu.backend.user.web;

import be.cbsaintlaurent.appdubleu.backend.user.dto.LoginRequest;
import be.cbsaintlaurent.appdubleu.backend.user.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        if (token == null) {
            System.out.println("login fail");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        System.out.println("login ok");
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Getter
    @AllArgsConstructor
    public static class JwtResponse {
        private String token;
    }
}

