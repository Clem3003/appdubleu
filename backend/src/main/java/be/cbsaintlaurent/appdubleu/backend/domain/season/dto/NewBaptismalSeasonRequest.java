package be.cbsaintlaurent.appdubleu.backend.domain.season.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBaptismalSeasonRequest {
    private Year startYear;
    private Year endYear;

    private String title; // "Season 24-25"
    private String pictureUrl; // Photo du comité avec penne et tête qui regarde par terre

    private boolean active;

}
