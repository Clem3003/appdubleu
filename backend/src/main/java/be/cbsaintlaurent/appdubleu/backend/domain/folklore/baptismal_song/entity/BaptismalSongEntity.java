package be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaptismalSongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String content;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDate createdAt;

    @ManyToOne
    private BaptismalSeasonEntity baptismalSeasonEntity;

}
