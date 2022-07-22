package First_API_01;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class NameController {

        @GetMapping(value = "/echo/{name}")
        public String getRoute(@PathVariable String name){

            return "ciao io sono " + name;
        }

        @PostMapping(value = "/echo/{name}")
        public String postRoute(@PathVariable String name){

            return reverse(name);
        }

        public static String reverse(String s){
            StringBuilder a = new StringBuilder();
            a.append(s);
            a.reverse();
            return a.toString();

        }

    }


