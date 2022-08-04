package com.ExecApi03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringController {


    @GetMapping("{a},{b}")
    public String getString(@RequestParam String a, @RequestParam String b){

        if (b == null){
            return a;
        }else if (a == true && b == true){
            return a + "  " + b;
        }

        return a;
    }

}
