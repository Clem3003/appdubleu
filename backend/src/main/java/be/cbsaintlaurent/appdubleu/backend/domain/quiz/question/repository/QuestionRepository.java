package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.repository;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Question> {

    QuestionEntity findById(UUID id);

    @Query(value = "SELECT * FROM question_entity WHERE active = true ORDER BY random() LIMIT 4", nativeQuery = true)
    List<QuestionEntity> findTop4ByActiveTrueOrderByRandom();

    boolean existsByPrompt(String prompt);
}
