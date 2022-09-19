package com.deploy01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/deploy")
public class HomeCotroler {


    @GetMapping("")
    public int mainEndpoint(){

        int min = 1;
        int max = 10;
        int n1 = (int) Math.floor(Math.random()(max-min+1)+min);
        int n2 = (int) Math.floor(Math.random()(max-min+1)+min);

        int sum = (n1 + n2);
        return sum;

    }

}

