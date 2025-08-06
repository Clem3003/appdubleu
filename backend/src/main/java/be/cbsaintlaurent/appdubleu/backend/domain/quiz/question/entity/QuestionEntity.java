package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.entity.BaptismalSongEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.entity.PinsEntity;
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
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String prompt;

    // Folklore reference
    @ManyToOne
    private BaptismalSongEntity baptismalSong;
    @ManyToOne
    private FolkloreSubjectEntity folkloreSubject;
    @ManyToOne
    private PinsEntity pins;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDate createdAt;
}
