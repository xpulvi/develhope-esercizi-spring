package middleware.e_interceptor02.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BasicController {

    @GetMapping("")
    public String getWelcomes(){
        return "welcomes user";
    }

}
