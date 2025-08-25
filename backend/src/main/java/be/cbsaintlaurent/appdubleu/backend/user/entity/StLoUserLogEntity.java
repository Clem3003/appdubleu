package be.cbsaintlaurent.appdubleu.backend.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "st_lo_user_log")
public class StLoUserLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private StLoUserEntity user;

    @Column(nullable = false)
    private String action; // ex: "LOGIN", "COMPLETE_TEST", "UPDATE_PROFILE"

    private String description; // ex: "User X completed folklore test #12"

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}

