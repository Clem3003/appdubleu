package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.web;


import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto.NewQuestionAttemptRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.service.QuestionAttemptService;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.season.service.BaptismalSeasonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question_attempt")
@Slf4j
@RequiredArgsConstructor
public class QuestionAttemptController {

    private final QuestionAttemptService service;

    @PostMapping
    public ResponseEntity<?> newSeason(@RequestBody NewQuestionAttemptRequest request) {
        var response = service.newQuestionAttempt(request); // TODO : manage errors better
        return ResponseEntity.ok(response);
    }
}
