package be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.entity.BaptismalSongEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.entity.PinsEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDateTime createdAt;
}
