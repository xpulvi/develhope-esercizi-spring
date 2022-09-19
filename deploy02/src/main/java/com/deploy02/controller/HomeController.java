package com.deploy02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deploy")
public class HomeController {

    @GetMapping("")
    public int mainEndpoint(){

        int min = 1;
        int max = 10;
        int n1 = (int) Math.floor(Math.random()*((max-min)+1+min));
        int n2 = (int) Math.floor(Math.random()*((max-min)+1+min));
        System.out.println(n1 +" " + n2);
        int sum = (n1 + n2);
        return sum;

    }
}
