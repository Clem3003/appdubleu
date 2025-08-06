package be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PinsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String title;
    private String pinsUrl;
    private String comment;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDate createdAt;

    @ManyToOne
    private BaptismalSeasonEntity baptismalSeasonEntity;
}
