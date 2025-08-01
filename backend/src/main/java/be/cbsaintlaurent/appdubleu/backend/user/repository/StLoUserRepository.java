package be.cbsaintlaurent.appdubleu.backend.user.repository;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StLoUserRepository extends JpaRepository<StLoUser, Long> {

    boolean existsByUsername(String username);

    Optional<StLoUser> findByUsername(String username);
}

