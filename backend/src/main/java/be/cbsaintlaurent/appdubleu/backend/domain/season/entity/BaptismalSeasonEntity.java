package be.cbsaintlaurent.appdubleu.backend.domain.season.entity;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaptismalSeasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Year startYear;
    private Year endYear;

    private String Title; // "Season 24-25"

    private String pictureUrl; // Photo du comité avec penne et tête qui regarde par terre

    @ManyToOne
    private StLoUserEntity creator;
    private LocalDate creationDate;

    private boolean active;
}



