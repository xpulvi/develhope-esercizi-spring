package co.develhope.Cors.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/custom")
    public String getMessage(HttpServletRequest request){
        log.info("received a request from " + request.getHeader(HttpHeaders.ORIGIN));
        return "Hello";
    }
}
