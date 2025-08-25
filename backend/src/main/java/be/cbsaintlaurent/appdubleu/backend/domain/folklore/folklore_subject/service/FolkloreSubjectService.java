package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.service;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.NewFolkloreSubjectRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.mapper.FolkloreSubjectMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
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
public class FolkloreSubjectService {

    @Getter(AccessLevel.PROTECTED)
    private final FolkloreSubjectRepository repository;
    private final BaptismalSeasonRepository baptismalSeasonRepository;
    private final StLoUserRepository userRepository;

    @Getter(AccessLevel.PROTECTED)
    private final FolkloreSubjectMapper mapper;
    private final BaptismalSeasonMapper baptismalSeasonMapper;


//    @Transactional
//    public BaptismalSeason newSeason(NewBaptismalSeasonRequest request) {
//
//        // Crée directement l'entité Season
//        BaptismalSeasonEntity seasonEntity = new BaptismalSeasonEntity();
//        seasonEntity.setTitle(request.getTitle());
//        seasonEntity.setPictureUrl(request.getPictureUrl());
//        seasonEntity.setStartYear(request.getStartYear());
//        seasonEntity.setEndYear(request.getEndYear());
//        seasonEntity.setCreatedBy(userEntity);
//        seasonEntity.setCreatedAt(LocalDateTime.now());
//
//        // Sauvegarde et renvoie un DTO
//        BaptismalSeasonEntity savedSeason = repository.save(seasonEntity);
//        return mapper.toDto(savedSeason);
//    }

    @Transactional
    public ResponseEntity<?> register(NewFolkloreSubjectRequest request) {
        // Récupère l'utilisateur connecté (entité gérée par Hibernate)
        StLoUserEntity userEntity = userRepository
                .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        FolkloreSubjectEntity folkloreSubjectEntity = new FolkloreSubjectEntity();
        folkloreSubjectEntity.setTitle(request.getTitle());
        folkloreSubjectEntity.setContent(request.getContent());
        folkloreSubjectEntity.setPictureUrl(request.getPictureUrl());
        folkloreSubjectEntity.setCreatedBy(userEntity);
        folkloreSubjectEntity.setCreatedAt(LocalDateTime.now());
        folkloreSubjectEntity.setBaptismalSeasonEntity(baptismalSeasonRepository.findFirstByActive(true));
        folkloreSubjectEntity.setActive(true);

        var response = repository.save(folkloreSubjectEntity);
        return ResponseEntity.ok(mapper.toDto(response));
    }

    public boolean existsBySubjectTitle(String title) {
        return repository.existsByTitle(title);
    }
}

