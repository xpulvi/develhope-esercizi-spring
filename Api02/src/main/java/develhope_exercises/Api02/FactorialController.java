package develhope_exercises.Api02;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api02")
public class FactorialController {

    @GetMapping(value = "/echo/num/{numb}")
    //come facio a fare passare numb come input da utentr?
    public String numtRoute(@PathVariable Integer numb) {

        int i, fact = 1;

        for (i=1;i<=numb;i++){
            fact=fact*i;
        }

        return "ciao io sono il numero fatoriale:" + fact + " di: " + numb ;
    }



}

