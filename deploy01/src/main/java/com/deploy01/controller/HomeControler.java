package com.deploy01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {

    @GetMapping
    public String GetHello(){
        return "hello";
    }
}
