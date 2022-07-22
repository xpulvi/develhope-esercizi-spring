package dependency_Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

/*
        @Autowired
        private MyService MyService;

    public MyController(dependency_Injection.MyService myService) {
        MyService = myService;
    }

    @GetMapping
        public String get(){
            return helloService.getHello();
        }

        @GetMapping("/pippo")
        public String getPippo(){
            return "Ciao io sono pippo";
        }
*/
}
