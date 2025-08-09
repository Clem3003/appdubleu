package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.entity;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
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
public class QuestionAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private StLoUserEntity userEntity;

    @ManyToOne
    private QuestionEntity questionEntity;

    private String attemptAnswer;

    private boolean success;

    @ManyToOne
    private StLoUserEntity createdBy;
    private LocalDateTime createdAt;
}
