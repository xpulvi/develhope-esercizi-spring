package dev.dmgiangi.logging.controllers;

import dev.dmgiangi.logging.exception.Exception;
import dev.dmgiangi.logging.services.NumberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final NumberService service;

    @GetMapping("")
    public String getWelcomeMessage(){
        String welcomeMessage = "Hello There";
        logger.info(welcomeMessage);
        return welcomeMessage;
    }

    @GetMapping("/exp")
    public Double pow(){
        return service.getPow();
    }

    @GetMapping("/get-errors")
    public Void logError(){
        throw new Exception("Ciao sono lorenzo e ti ho inchiodato il server");
    }
}
