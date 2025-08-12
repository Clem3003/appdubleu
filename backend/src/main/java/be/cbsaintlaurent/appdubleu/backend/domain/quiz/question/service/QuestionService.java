package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.service;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.NewQuestionRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.mapper.QuestionMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.repository.QuestionRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    @Getter(AccessLevel.PROTECTED)
    private final QuestionRepository repository;
    private final FolkloreSubjectRepository folkloreSubjectRepository;
    private final StLoUserRepository userRepository;
    @Getter(AccessLevel.PROTECTED)
    private final QuestionMapper mapper;

    @Transactional
    public Question newQuestion(NewQuestionRequest request) {
        // Récupère l'utilisateur connecté (entité gérée par Hibernate)
        StLoUserEntity userEntity = userRepository
            .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
            .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setPrompt(request.getPrompt());
        questionEntity.setSuggestedAnswer_1(request.getSuggestedAnswer_1());
        questionEntity.setSuggestedAnswer_2(request.getSuggestedAnswer_2());
        questionEntity.setSuggestedAnswer_3(request.getSuggestedAnswer_3());
        questionEntity.setSuggestedAnswer_4(request.getSuggestedAnswer_4());
        questionEntity.setCorrectAnswer(request.getCorrectAnswer());
        questionEntity.setActive(request.getActive());
        questionEntity.setCreatedBy(userEntity);
        questionEntity.setBaptismalSong(null);
        questionEntity.setFolkloreSubject(folkloreSubjectRepository.findById(request.getFolkloreSubject().getId()));
        questionEntity.setPins(null);
        questionEntity.setCreatedAt(LocalDateTime.now());

        QuestionEntity response = repository.save(questionEntity);
        return mapper.toDto(response);
    }

    public List<Question> getActiveQuestions() {
        return this.mapper.toDto(this.repository.findAll());
    }
    public List<Question> getFourRandomActiveQuestions() {
        return this.mapper.toDto(this.repository.findTop4ByActiveTrueOrderByRandom());
    }
}