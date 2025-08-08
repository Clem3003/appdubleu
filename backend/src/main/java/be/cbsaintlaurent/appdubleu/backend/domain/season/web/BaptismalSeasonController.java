package be.cbsaintlaurent.appdubleu.backend.domain.season.web;


import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baptismal_season")
@Slf4j
@RequiredArgsConstructor
public class BaptismalSeasonController {

    @PostMapping
    public ResponseEntity<?> newSeason(@RequestBody NewBaptismalSeasonRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Current Authentication: " + auth);
        return ResponseEntity.ok("test");
    }
}
