package be.cbsaintlaurent.appdubleu.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StLoUserSummary {
    private UUID id;
    private String username;
}
