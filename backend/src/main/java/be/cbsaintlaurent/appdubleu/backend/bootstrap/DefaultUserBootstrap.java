package be.cbsaintlaurent.appdubleu.backend.bootstrap;

import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultUserBootstrap {

    private final AuthService userService;
//    private final ApplicationProperties appProperties;

//    @PostConstruct
    public void initDefaultUsers() {
//        log.info("Bootstrap default users for environment: {}"/*, appProperties.getEnvironment()*/);

//        if (appProperties.isEnvironment("dev", "int")) {
            createUserIfNotExists("admin", "Admin", "User", "admin@stlo.com", "admin123", StLoRole.ADMIN); // TODO : REMOVE USER/PWD Admin/Admin123
            createUserIfNotExists("clement.lemlijn.ancien", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.ANCIEN);
            createUserIfNotExists("clement.lemlijn", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.CAPE);
            createUserIfNotExists("clement.lemlijn.ass", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.ASSISTANT);
            createUserIfNotExists("clement.lemlijn.NEO", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.NEO);
            createUserIfNotExists("clement.lemlijn.bleu", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.BLEU);
            createUserIfNotExists("clement.lemlijn.user", "Clément", "Lemlijn", "clement.lemlijn@gmail.com", "password", StLoRole.USER);
            // ajoute d'autres utilisateurs ici...
//        }
    }

    private void createUserIfNotExists(String username, String firstName, String lastName, String email, String password, StLoRole role) {
        if (!userService.existsByUsername(username)) {
            userService.register(username, firstName, lastName, email, password, role);
//            log.info("Created user {}", username);
        }
    }
}
