package be.cbsaintlaurent.appdubleu.backend.bootstrap;

import be.cbsaintlaurent.appdubleu.backend.user.dto.RegisterRequest;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultUserBootstrap {

    private final AuthService authService;
//    private final ApplicationProperties appProperties;

    @PostConstruct
    public void initDefaultUsers() {
//        log.info("Bootstrap default users for environment: {}"/*, appProperties.getEnvironment()*/);

//        if (appProperties.isEnvironment("dev", "int")) {
            createUserIfNotExists("admin", "Admin", "User","Admin", LocalDate.of(2005, 3, 30), "admin@stlo.com", "admin123", StLoRole.ADMIN); // TODO : REMOVE USER/PWD Admin/Admin123
//            createUserIfNotExists("clement.lemlijn.ancien", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.ANCIEN);
//            createUserIfNotExists("clement.lemlijn", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.CAPE);
//            createUserIfNotExists("clement.lemlijn.ass", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.ASSISTANT);
//            createUserIfNotExists("clement.lemlijn.NEO", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.NEO);
//            createUserIfNotExists("clement.lemlijn.bleu", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.BLEU);
//            createUserIfNotExists("clement.lemlijn.user", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.USER);
            // ajoute d'autres utilisateurs ici...
//        }
    }

    private void createUserIfNotExists(String username, String firstname, String lastname, String nickname, LocalDate dateOfBirth, String email, String password, StLoRole role) {
        if (!authService.existsByUsername(username)) {
            authService.register(new RegisterRequest(lastname, firstname, nickname, dateOfBirth, email, "", password));
//            log.info("Created user {}", username);
        }
    }
}
