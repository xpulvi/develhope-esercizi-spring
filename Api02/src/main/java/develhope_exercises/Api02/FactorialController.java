package develhope_exercises.Api02;

import develhope_exercises.Api02.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/api02")
public class FactorialController {

    // toglimi

    @GetMapping(value = "/echo/{id}")
    //@RequestParam ci metti i parametri che usera poi la tua richiesta
    public String getRoute(@PathVariable String id, @RequestParam(required = false) Integer quantity, @RequestHeader HttpHeaders headers ) { /*@RequestHeader serve a fare validazione (ti permete di fare debag sulla chiamata che crei*/

        return "ciao io sono il get" + id + "quantity is " + quantity;
    }

    @PostMapping(value = "/echo")
    public String postRoute(@RequestBody UserDto user ) {
        return user.toString();
    }

    @DeleteMapping(value = "/echo")
    public String deliteRoute() {
        return "ciao io sono il delit";
    }
    //--------------------------------fino a qui e da togliere
    @GetMapping(value = "/echo/num")
    public String numtRoute() {

        int i, fact = 1;
        int numb = 5;
        for (i=1;i<=numb;i++){
            fact=fact*i;
        }

        return "ciao io sono il numero fatoriale:" + fact + " di: " + numb ;
    }



}

