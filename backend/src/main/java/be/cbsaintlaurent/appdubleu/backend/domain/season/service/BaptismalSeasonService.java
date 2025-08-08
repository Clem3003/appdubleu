package be.cbsaintlaurent.appdubleu.backend.domain.season.service;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class BaptismalSeasonService {

    @Getter(AccessLevel.PROTECTED)
    private final BaptismalSeasonRepository repository;
    @Getter(AccessLevel.PROTECTED)
    private final BaptismalSeasonMapper mapper;

    @Transactional
    public ResponseEntity<?> newSeason(NewBaptismalSeasonRequest request) {

        BaptismalSeason season = new BaptismalSeason();
        season.setTitle(request.getTitle());
        season.setPictureUrl(request.getPictureUrl());
        season.setStartYear(request.getStartYear());
        season.setEndYear(request.getEndYear());
        season.setCreationDate(LocalDate.now());

        BaptismalSeasonEntity response = repository.save(mapper.toEntity(season));
        return ResponseEntity.ok(mapper.toDto(response));
    }

    public ResponseEntity<?> getCurrentBaptismalSeason() {
        return ResponseEntity.ok(repository.findFirstByActive(true));
    }
}
