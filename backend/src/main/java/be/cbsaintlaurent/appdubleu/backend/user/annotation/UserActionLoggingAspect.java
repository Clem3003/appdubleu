package be.cbsaintlaurent.appdubleu.backend.user.annotation;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserLogEntity;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserLogRepository;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
@RequiredArgsConstructor
public class UserActionLoggingAspect {

    private final StLoUserLogRepository userLogRepository;
    private final StLoUserRepository userRepository;

    @Around("@annotation(loggableAction)")
    public Object logUserAction(ProceedingJoinPoint joinPoint, LoggableAction loggableAction) throws Throwable {
        Object result = joinPoint.proceed();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            StLoUserEntity user = userRepository.findByUsername(authentication.getName()).orElse(null);

            StLoUserLogEntity log = new StLoUserLogEntity();
            log.setUser(user);
            log.setUsername(authentication.getName());
            log.setAction(loggableAction.value());
            log.setDescription(loggableAction.description());
            log.setCreatedAt(LocalDateTime.now());

            userLogRepository.save(log);
        }

        return result;
    }
}
