package co.develhope.diDemo.services;

import co.develhope.diDemo.utils.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private MyComponent myComponentVariable;

    public MyService(MyComponent myComponentVariable) {
        this.myComponentVariable = myComponentVariable;
    }

    public MyComponent getNamee() {
        return myComponentVariable;
    }

    /*  @Value("${spring.helloMessage}")
    private String helloMessage; */



   // MyService(AnotherHelloService numberOfHello){ }


   /* public String getHello(){
        return helloMessage;
    } */
}
