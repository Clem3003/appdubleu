package be.cbsaintlaurent.appdubleu.backend.user.annotation;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserLogEntity;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserLogRepository;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
        StLoUserEntity user = null;
        String username = "anonymous";

        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            System.out.println("authenticated");
            user = userRepository.findByUsername(authentication.getName()).orElse(null);
            username = authentication.getName();
        }
        else {
            System.out.println("not authenticated");

        }

        StLoUserLogEntity log = new StLoUserLogEntity();
        log.setUser(user);  // null si anonyme
        log.setUsername(username);
        log.setAction(loggableAction.value());
        log.setDescription(loggableAction.description());
        log.setCreatedAt(LocalDateTime.now());

        userLogRepository.save(log);

//        if (authentication != null) {
//            System.out.println("!=null" + authentication + authentication.getName() + authentication.isAuthenticated());
//            StLoUserEntity user = userRepository.findByUsername(authentication.getName()).orElse(null);
//
//            StLoUserLogEntity log = new StLoUserLogEntity();
//            log.setUser(user);
//            log.setUsername(authentication.getName());
//            log.setAction(loggableAction.value());
//            log.setDescription(loggableAction.description());
//            log.setCreatedAt(LocalDateTime.now());
//
//            userLogRepository.save(log);
//        } else {
//            System.out.println("==null");
//        }

        return result;
    }
}
