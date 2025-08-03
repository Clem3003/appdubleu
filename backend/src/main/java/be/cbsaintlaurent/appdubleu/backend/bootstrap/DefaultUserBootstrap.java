package be.cbsaintlaurent.appdubleu.backend.bootstrap;

import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.service.StLoUserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultUserBootstrap {

    private final StLoUserService userService;
//    private final ApplicationProperties appProperties;

//    @PostConstruct
    public void initDefaultUsers() {
//        log.info("Bootstrap default users for environment: {}"/*, appProperties.getEnvironment()*/);

//        if (appProperties.isEnvironment("dev", "int")) {
            createUserIfNotExists("admin", "Admin", "User", "admin@example.com", "admin123", StLoRole.ADMIN);
            createUserIfNotExists("clement.lemlijn", "Clément", "Lemlijn", "clement@example.com", "password", StLoRole.ADMIN);
            // ajoute d'autres utilisateurs ici...
//        }
    }

    private void createUserIfNotExists(String username, String firstName, String lastName, String email, String password, StLoRole role) {
        if (!userService.existsByUsername(username)) {
            userService.createUser(username, firstName, lastName, email, password, role);
//            log.info("Created user {}", username);
        }
    }
}
