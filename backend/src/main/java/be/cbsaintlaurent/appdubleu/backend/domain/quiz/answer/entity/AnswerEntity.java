package be.cbsaintlaurent.appdubleu.backend.domain.quiz.answer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String answer;

}
