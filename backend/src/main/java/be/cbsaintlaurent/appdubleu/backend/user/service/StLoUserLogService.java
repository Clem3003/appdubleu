package be.cbsaintlaurent.appdubleu.backend.user.service;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserLogEntity;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StLoUserLogService {

    private final StLoUserLogRepository userLogRepository;

    public void log(StLoUserEntity user, String action, String description) {
        StLoUserLogEntity log = new StLoUserLogEntity();
        log.setUser(user);
        log.setAction(action);
        log.setDescription(description);
        log.setCreatedAt(LocalDateTime.now());

        userLogRepository.save(log);
    }
}

