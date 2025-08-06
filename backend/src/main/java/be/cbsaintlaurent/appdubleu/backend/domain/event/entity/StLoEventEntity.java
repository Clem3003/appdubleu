package be.cbsaintlaurent.appdubleu.backend.domain.event.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StLoEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String pictureUrl;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String location;

//    @ManyToMany
//    private List<StLoUserEntity> participants;
}
