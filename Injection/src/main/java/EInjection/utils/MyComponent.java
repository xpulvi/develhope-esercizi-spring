package EInjection.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class MyComponent {

    //an instance string variable called myComponentName
    public String myComponentName;
    public String myName = "nik";

    // a constructor that assigns your name to the instance variable
    public MyComponent(String myComponentName , String myName) {
        this.myComponentName = myComponentName;
        this.myName = myName;
        System.out.println(myName);
    }

    /* a method getMyComponentName() that returns the value of myComponentImmutableName.
    @Pasquale non ho capito cosa intenda con: that returns the value of myComponentImmutableName. (oltre a fargli il get non capisco cosa voglia */
    @GetMapping
    public String getMyComponentName() {

        return "myComponentImmutableName: " + myComponentName;
    }
}
