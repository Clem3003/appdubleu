package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.dto.BaptismalSong;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.dto.Pins;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Question {
    private UUID id;

    private String prompt;

    // Folklore reference
    private BaptismalSong baptismalSong;
    private FolkloreSubject folkloreSubject;
    private Pins pins;

    private String suggestedAnswer_1;
    private String suggestedAnswer_2;
    private String suggestedAnswer_3;
    private String suggestedAnswer_4;

    private Integer correctAnswer;


    private StLoUser createdBy;
    private LocalDateTime createdAt;
}
