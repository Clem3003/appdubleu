package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.service;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.NewQuestionRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.mapper.QuestionMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.repository.QuestionRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto.NewQuestionAttemptRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto.QuestionAttempt;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.entity.QuestionAttemptEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.mapper.QuestionAttemptMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.repository.QuestionAttemptRepository;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionAttemptService {

    @Getter(AccessLevel.PROTECTED)
    private final QuestionAttemptRepository repository;
    private final QuestionRepository questionRepository;
    private final StLoUserRepository userRepository;
    @Getter(AccessLevel.PROTECTED)
    private final QuestionAttemptMapper mapper;
    private final QuestionMapper questionMapper;

    @Transactional
    public QuestionAttempt newQuestionAttempt(NewQuestionAttemptRequest request) {
        // Récupère l'utilisateur connecté (entité gérée par Hibernate)
        StLoUserEntity userEntity = userRepository
                .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        QuestionEntity questionEntity = questionRepository.findById(request.getQuestion().getId());
        boolean isAnswerCorrect = isAnswerCorrect(questionEntity, request.getAttemptAnswer());

        QuestionAttemptEntity questionAttemptEntity = new QuestionAttemptEntity();
        questionAttemptEntity.setQuestionEntity(questionEntity);
        questionAttemptEntity.setUserEntity(userEntity);
        questionAttemptEntity.setAttemptAnswer(request.getAttemptAnswer());
        questionAttemptEntity.setSuccess(isAnswerCorrect);
        questionAttemptEntity.setCreatedBy(userEntity);
        questionAttemptEntity.setCreatedAt(LocalDateTime.now());
        QuestionAttemptEntity response = repository.save(questionAttemptEntity);
        return mapper.toDto(response);
    }

    private boolean isAnswerCorrect(QuestionEntity questionEntity, String answer){
        switch (questionEntity.getCorrectAnswer()){
            case 1:
                if (answer.equals(questionEntity.getSuggestedAnswer_1()))
                    return true;
                break;
            case 2:
                if (answer.equals(questionEntity.getSuggestedAnswer_2()))
                    return true;
                break;
            case 3:
                if (answer.equals(questionEntity.getSuggestedAnswer_3()))
                    return true;
                break;
            case 4:
                if (answer.equals(questionEntity.getSuggestedAnswer_4()))
                    return true;
                break;
            default:
                return false;
        }
        return false;
    }
}