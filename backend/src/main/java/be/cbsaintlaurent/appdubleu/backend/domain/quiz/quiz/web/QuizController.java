package be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.web;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.dto.NewQuizRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@Slf4j
@RequiredArgsConstructor
public class QuizController {

    private final QuizService service;

    @PostMapping
    public ResponseEntity<?> newQuiz(@RequestBody NewQuizRequest request) {
        var response = service.newQuiz(request);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/getActiveQuestions")
//    public ResponseEntity<?> getActiveQuestion() {
//        var response = service.getActiveQuestions();
//        return ResponseEntity.ok(response);
//    }
}
