package be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaptismalSong {
    private UUID id;

    private String title;
    private String content;
    private String author;

    private StLoUser createdBy;
    private LocalDateTime createdAt;

    private BaptismalSeason baptismalSeasonEntity;
}
