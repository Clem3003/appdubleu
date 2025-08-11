package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.web;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.NewQuestionRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@Slf4j
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService service;

    @PostMapping
    public ResponseEntity<?> newQuestion(@RequestBody NewQuestionRequest request) {
        var response = service.newQuestion(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getActiveQuestions")
    public ResponseEntity<?> getActiveQuestion() {
        var response = service.getActiveQuestions();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getFourRandomActiveQuestions")
    public ResponseEntity<?> getFourRandomActiveQuestion() {
        var response = service.getFourRandomActiveQuestions();
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
}
