package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class FolkloreSubject {
    private UUID id;

    private String Title;
    private String content;
    private String pictureUrl;

    private StLoUser createdBy;
    private LocalDate createdAt;

    private BaptismalSeason baptismalSeason;

    private boolean active;

}
