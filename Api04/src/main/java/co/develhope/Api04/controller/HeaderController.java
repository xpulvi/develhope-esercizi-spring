package co.develhope.Api04.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api04")
public class HeaderController {

    @GetMapping(value = "/echo/{surname}")
    //come facio a fare passare numb come input da utentr?
    public String numtRoute(@PathVariable String surname){

        return "mirto fa di cogniome: " + surname;
    }

    @DeleteMapping("/echo")
    public String deliteRoute() {

        return "ciao io sono il delit";
    }

}
