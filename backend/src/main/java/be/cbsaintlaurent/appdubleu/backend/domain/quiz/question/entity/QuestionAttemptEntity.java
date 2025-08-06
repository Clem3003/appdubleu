package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @ManyToOne
    private QuestionEntity questionEntity;


}
