package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.repository;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto.QuestionAttempt;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.entity.QuestionAttemptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAttemptRepository extends JpaRepository<QuestionAttemptEntity, QuestionAttempt> {

}