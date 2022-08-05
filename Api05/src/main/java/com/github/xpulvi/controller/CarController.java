package com.github.xpulvi.controller;

import com.github.xpulvi.dto.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

    //on a GET request returns a new Car as response | io ho capito di fare cosi:
    @GetMapping(value = "/echo")
    public String getNewCsr(@RequestParam(required = true) String id, @RequestParam(required = true) String modelName,
                     @RequestParam(required = false) Double price){

        return "new Car" ;
    }

    // on a POST request prints the Car body in console and returns an HTTP Created success message to the user
    @PostMapping(value = "/echo")
    public String postPrintCarBody(@Valid @RequestBody(required = true)CarDTO car){
        System.out.println(car.toString());
        // non ho caoito bene come usarlo sul return: new ResponseBody<String>(HttpStatus.OK) sul return
        return "HTTP Created success";
    }

}
