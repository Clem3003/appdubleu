package be.cbsaintlaurent.appdubleu.backend.user.web;

import be.cbsaintlaurent.appdubleu.backend.user.service.StLoUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class StLoUserController {

    private final StLoUserService service;


}
