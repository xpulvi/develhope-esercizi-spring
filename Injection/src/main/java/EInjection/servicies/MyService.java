package EInjection.servicies;

import EInjection.utils.MyComponent;
import org.springframework.stereotype.Service;

@Service
public class MyService extends MyComponent{

    /* a private variable MyComponent
    @Pasquale varibile privata ok ma il tipo lo posso scegliere ho devo mettere il tipo che voglio? */
    private EInjection.utils.MyComponent MyComponent;

    /* a constructor where you apply constructor-based dependency injection
    @Pasquale non ho capito come farlo. mi verebe da usare i super,
     ma la richiesta e di usare il costrutore che ho ignetato prima. (pero non lo prende)
     */

    public MyService(MyComponent myComponent) {
        MyComponent = myComponent;
    }

    /* a method getName() that calls and returns getMyComponentName()
     */
    public String getName() {

        return " getName is: " + getMyComponentName();
    }
}
