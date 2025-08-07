package be.cbsaintlaurent.appdubleu.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RegisterRequest {

    private String lastname;
    private String firstname;
    private String nickname;
    private LocalDate dateOfBirth;
    private String email;

    private String profilePictureUrl;
    private String password;

}
