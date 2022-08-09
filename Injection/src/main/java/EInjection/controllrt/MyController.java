package EInjection.controllrt;

import EInjection.servicies.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    //a private variable MyService
    private MyService myService;

    //constructor
    public MyController(EInjection.servicies.MyService myService) {
        myService = myService;
    }

    /* a mapping to /getName in order to return the result of the getName() method of the MyService variable
    @pasquale non ho capito come vuole che lo facia.
     */
    //@GetMapping("/getName")


    public MyService getMyService() {
        return myService;
    }

    /* a mapping to default root / that prints a welcome message
            se non ho capito male vuole che facia questo:
         */
    @GetMapping()
    public String getWelcome(){
        return "welcome";
    }


}
