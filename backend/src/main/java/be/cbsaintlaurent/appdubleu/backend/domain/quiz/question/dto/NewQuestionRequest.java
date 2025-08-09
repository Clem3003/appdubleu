package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.dto.BaptismalSong;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.dto.Pins;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NewQuestionRequest {
    private UUID id;

    private String prompt;

    // Folklore reference
    private BaptismalSong baptismalSong;
    private FolkloreSubject folkloreSubject;
    private Pins pins;

    private StLoUser createdBy;
    private LocalDateTime createdAt;
}
