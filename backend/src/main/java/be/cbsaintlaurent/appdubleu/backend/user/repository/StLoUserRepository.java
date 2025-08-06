package be.cbsaintlaurent.appdubleu.backend.user.repository;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StLoUserRepository extends JpaRepository<StLoUserEntity, Long> {

    boolean existsByUsername(String username);

    Optional<StLoUserEntity> findByUsername(String username);
}

