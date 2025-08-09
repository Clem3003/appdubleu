package be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Pins {
    private UUID id;

    private String title;
    private String pinsUrl;
    private String comment;

    private BaptismalSeason baptismalSeasonEntity;

    private StLoUser createdBy;
    private LocalDateTime createdAt;
}
