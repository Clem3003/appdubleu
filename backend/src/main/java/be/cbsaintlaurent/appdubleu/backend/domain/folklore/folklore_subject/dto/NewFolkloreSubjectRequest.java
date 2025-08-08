package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewFolkloreSubjectRequest {

    private String Title;
    private String content;
    private String pictureUrl;
}
