package be.cbsaintlaurent.appdubleu.backend.user.repository;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StLoUserLogRepository extends JpaRepository<StLoUserLogEntity, Long> {

}

