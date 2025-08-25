package be.cbsaintlaurent.appdubleu.backend.domain.season.repository;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BaptismalSeasonRepository extends JpaRepository<BaptismalSeasonEntity, BaptismalSeason> {

    BaptismalSeasonEntity findFirstByActive(boolean active);

    boolean existsByTitle(String title);
}

