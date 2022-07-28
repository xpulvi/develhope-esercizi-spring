package co.develhope.Api04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HeaderController {

    @GetMapping(value = "/echo/{name}")
    public String getRoute(@PathVariable String name){

        return "ciao io sono " + name;
    }

}
