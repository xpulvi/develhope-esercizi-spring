package co.develhope.diDemo.utils;

import co.develhope.diDemo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Autowired
    private String myComponentName;

    /* a constructor that assigns your name to the instance variable | ok ma non ho capito come se la varibile la vuole cosi myName?*/

    public MyComponent(String myComponentName, String myName){
        this.myComponentName = myComponentName;
        myName = "nik";
    }

    public String getMyComponentName() {
        return myComponentName;
    }
}



