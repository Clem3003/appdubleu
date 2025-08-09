package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class QuestionAttempt {
    private UUID id;

    private StLoUser user;

    private Question question;

    private String attemptAnswer;

    private boolean success;

    private StLoUser createdBy;
    private LocalDateTime createdAt;
}
