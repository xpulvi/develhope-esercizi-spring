package com.xpulvi.github.Swagger1.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomControler {

    @ApiOperation(value = "welcome generator", tags = "ciao a tutti")

    @GetMapping("/")
    public String sauta(){
        return "hello World";
    }



}
