package co.develhope.diDemo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Value("${spring.helloMessage}")
    private String helloMessage;

    MyService(AnotherHelloService numberOfHello){

    }

    public String getHello(){
        return helloMessage;
    }
}
