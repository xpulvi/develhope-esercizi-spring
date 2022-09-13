package environments.variables02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String mainEndpoint(){
        String welcomeMsg = environment.getProperty("welcomeMsg");
        return welcomeMsg ;
    }

}
