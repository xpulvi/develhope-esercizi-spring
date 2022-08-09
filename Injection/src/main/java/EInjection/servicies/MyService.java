package EInjection.servicies;

import EInjection.utils.MyComponent;
import org.springframework.stereotype.Service;

@Service
public class MyService extends MyComponent{

    // a private variable MyComponent
    private EInjection.utils.MyComponent MyComponent;

    // a constructor where you apply constructor-based dependency injection
    public MyService(EInjection.utils.MyComponent myComponent) {
        MyComponent = myComponent;
    }

    /* a method getName() that calls and returns getMyComponentName()
    @pasuqale: non ho capito come farlo.
     */
    public EInjection.utils.MyComponent getName() {

        return " getName is: " + getMyComponentName();
    }
}
