package be.cbsaintlaurent.appdubleu.backend.domain.season.dto;

import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaptismalSeason {
    private UUID id;

    private Year startYear;
    private Year endYear;

    private String title; // "Season 24-25"

    private String pictureUrl; // Photo du comité avec penne et tête qui regarde par terre

    private StLoUser createdBy;
    private LocalDateTime createdAt;

    private boolean active;

}
