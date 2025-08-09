package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.Data;

import java.util.UUID;

@Data
public class NewQuestionAttemptRequest {
    private UUID id;

    private StLoUser user;

    private Question question;

    private String attemptAnswer;

}
