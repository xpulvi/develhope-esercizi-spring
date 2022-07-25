package devlhope.Api05;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {

    @GetMapping
    public String mario(){
        return "ciaoo bbello";
    }

}
