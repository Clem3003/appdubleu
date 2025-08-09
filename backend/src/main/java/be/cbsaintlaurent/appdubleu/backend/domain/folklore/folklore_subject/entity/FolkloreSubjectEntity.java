package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FolkloreSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String Title;
    private String content;
    private String pictureUrl;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDateTime createdAt;

    @ManyToOne
    private BaptismalSeasonEntity baptismalSeasonEntity;

    private boolean active;
}



