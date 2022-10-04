package com.deploy01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {

    @Value(value = "${environmentes.devName}")
    private String devName;

    @GetMapping("/hello")
    public String GetHello(){
        return "Hello " + devName;
    }
}
