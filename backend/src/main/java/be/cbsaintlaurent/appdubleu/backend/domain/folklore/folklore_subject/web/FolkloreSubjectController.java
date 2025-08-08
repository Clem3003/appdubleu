package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.web;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.NewFolkloreSubjectRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.service.FolkloreSubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/folklore_subject")
@Slf4j
@RequiredArgsConstructor
public class FolkloreSubjectController {

    private final FolkloreSubjectService service;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody NewFolkloreSubjectRequest request) {
        return service.register(request);
    }
}
