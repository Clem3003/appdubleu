package be.cbsaintlaurent.appdubleu.backend.domain.season.service;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUserSummary;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BaptismalSeasonService {

    @Getter(AccessLevel.PROTECTED)
    private final BaptismalSeasonRepository repository;
    private final StLoUserRepository userRepository;
    @Getter(AccessLevel.PROTECTED)
    private final BaptismalSeasonMapper mapper;
    private final StLoUserMapper userMapper;

    @Transactional
    public boolean existsBySeasonTitle(String title) {
        return repository.existsByTitle(title);
    }

    @Transactional
    public BaptismalSeason newSeason(NewBaptismalSeasonRequest request) {
        // Récupère l'utilisateur connecté (entité gérée par Hibernate)
        StLoUserEntity userEntity = userRepository
                .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // Crée directement l'entité Season
        BaptismalSeasonEntity seasonEntity = new BaptismalSeasonEntity();
        seasonEntity.setTitle(request.getTitle());
        seasonEntity.setPictureUrl(request.getPictureUrl());
        seasonEntity.setStartYear(request.getStartYear());
        seasonEntity.setEndYear(request.getEndYear());
        seasonEntity.setCreatedBy(userEntity);
        seasonEntity.setCreatedAt(LocalDateTime.now());

        // Sauvegarde et renvoie un DTO
        BaptismalSeasonEntity savedSeason = repository.save(seasonEntity);
        return mapper.toDto(savedSeason);
    }

    @Transactional
    public BaptismalSeason getCurrentBaptismalSeason() {
        return mapper.toDto(repository.findFirstByActive(true));
    }
}
