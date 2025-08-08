package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.entity.BaptismalSongEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.entity.PinsEntity;
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
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String prompt;

    // Folklore reference
    @ManyToOne
    private BaptismalSongEntity baptismalSong;
    @ManyToOne
    private FolkloreSubjectEntity folkloreSubject;
    @ManyToOne
    private PinsEntity pins;

    private String suggestedAnswer_1;
    private String suggestedAnswer_2;
    private String suggestedAnswer_3;
    private String suggestedAnswer_4;

    private Integer correctAnswer;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDate createdAt;
}
