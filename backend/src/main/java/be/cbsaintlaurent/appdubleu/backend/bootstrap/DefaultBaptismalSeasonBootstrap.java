package be.cbsaintlaurent.appdubleu.backend.bootstrap;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.season.service.BaptismalSeasonService;
import be.cbsaintlaurent.appdubleu.backend.user.dto.RegisterRequest;
import be.cbsaintlaurent.appdubleu.backend.user.enums.StLoRole;
import be.cbsaintlaurent.appdubleu.backend.user.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@Component
@AllArgsConstructor
@Slf4j
public class DefaultBaptismalSeasonBootstrap {

    private final BaptismalSeasonService service;
    private final BaptismalSeasonRepository repository;

    @PostConstruct
    public void initDefaultUsers() {
            createIfNotExists("Season 24-25", "2024", "2025",""); // TODO : REMOVE USER/PWD Admin/Admin123
    }

    private void createIfNotExists(String title, String startYear, String endYear, String pictureURL) {
        if (!service.existsBySeasonTitle(title)) {
            // Crée directement l'entité Season
            BaptismalSeasonEntity seasonEntity = new BaptismalSeasonEntity();
            seasonEntity.setTitle(title);
            seasonEntity.setPictureUrl(pictureURL);
            seasonEntity.setStartYear(Year.of(Integer.parseInt(startYear)));
            seasonEntity.setEndYear(Year.of(Integer.parseInt(endYear)));
            seasonEntity.setActive(true);
            seasonEntity.setCreatedBy(null);
            seasonEntity.setCreatedAt(LocalDateTime.now());

            // Sauvegarde et renvoie un DTO
            BaptismalSeasonEntity savedSeason = repository.save(seasonEntity);
        }
    }
}
