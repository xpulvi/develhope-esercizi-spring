package co.develhope.diDemo.controllers;

import co.develhope.diDemo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //it is a component
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping
    public String get(){
        return myService.getHello();
    }

    @GetMapping("/pippo")
    public String getPippo(){
        return "Ciao io sono pippo";
    }
}
