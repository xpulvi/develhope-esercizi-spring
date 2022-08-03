package co.develhope.diDemo.utils;

import co.develhope.diDemo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Autowired
    private String myComponentName;

    public MyComponent(String myComponentName, String myName){
        this.myComponentName = myComponentName;
         ame = "nic;
    }

    public String getMyComponentName() {
        return myComponentName;
    }
}



