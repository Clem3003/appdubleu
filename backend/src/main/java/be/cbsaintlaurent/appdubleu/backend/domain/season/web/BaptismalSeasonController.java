package be.cbsaintlaurent.appdubleu.backend.domain.season.web;


import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.NewBaptismalSeasonRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.season.service.BaptismalSeasonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/baptismal_season")
@Slf4j
@RequiredArgsConstructor
public class BaptismalSeasonController {

    private final BaptismalSeasonService service;

    @PostMapping
    public ResponseEntity<?> newSeason(@RequestBody NewBaptismalSeasonRequest request) {
        var response = service.newSeason(request); // TODO : manage errors better
        return ResponseEntity.ok(response);
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrent() {
        return service.getCurrentBaptismalSeason();
    }
}
