package be.cbsaintlaurent.appdubleu.backend.user.dto;

import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class StLoUser {

    private UUID id;

    private String lastname;
    private String firstname;

    private String username;
    private LocalDate dateOfBirth;

    private String email;
    private String password;

    private StLoRole role;

    private boolean active;
    private LocalDate registerDate;
    private String profilePictureUrl;
    private String nickname;

}
