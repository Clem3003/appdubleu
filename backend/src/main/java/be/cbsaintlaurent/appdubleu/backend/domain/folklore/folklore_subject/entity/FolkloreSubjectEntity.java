package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FolkloreSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String Title;
    private String content;
    private String pictureUrl;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDate createdAt;

    @ManyToOne
    private BaptismalSeasonEntity baptismalSeasonEntity;

    private boolean active;
}



