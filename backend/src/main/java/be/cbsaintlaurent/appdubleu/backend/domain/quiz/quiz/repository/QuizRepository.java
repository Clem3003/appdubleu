package be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.repository;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.dto.Quiz;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Quiz> {

    QuizEntity findById(UUID id);
}
