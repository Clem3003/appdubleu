package be.cbsaintlaurent.appdubleu.backend.user.entity;

import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class UserRoleHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private StLoUser user;

    @Enumerated(EnumType.STRING)
    private StLoRole role;

    private LocalDate startDate;

    private LocalDate endDate; // null si rôle encore actif
}
