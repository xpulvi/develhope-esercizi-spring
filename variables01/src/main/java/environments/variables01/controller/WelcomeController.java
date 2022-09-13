package environments.variables01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String mainEndpoint(){
        String devName = environment.getProperty("devName");
        String authCode = environment.getProperty("authCode");
        return devName +" welcome" + " autore di: " + authCode;
    }

}
