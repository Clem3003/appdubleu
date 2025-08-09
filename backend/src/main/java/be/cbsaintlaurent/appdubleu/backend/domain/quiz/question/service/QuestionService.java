package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.service;

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
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    @Getter(AccessLevel.PROTECTED)
    private final QuestionRepository repository;
    @Getter(AccessLevel.PROTECTED)
    private final QuestionMapper mapper;

    @Transactional
    public ResponseEntity<?> newQuestion(NewQuestionRequest request) {

        Question question = new Question();
        question.setPrompt(request.getPrompt());
        question.setSuggestedAnswer_1(request.getPrompt());
        question.setSuggestedAnswer_2(request.getPrompt());
        question.setSuggestedAnswer_3(request.getPrompt());
        question.setSuggestedAnswer_4(request.getPrompt());
        question.setCorrectAnswer(2);
//        question.setFolkloreSubject();
        question.setCreatedAt(LocalDateTime.now());

        QuestionEntity response = repository.save(mapper.toEntity(question));
        return ResponseEntity.ok(mapper.toDto(response));
    }

//    public ResponseEntity<?> getCurrentBaptismalSeason() {
//        return ResponseEntity.ok(repository.findFirstByActive(true));
//    }
}