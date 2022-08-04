package com.ExecApi03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringController {

    @GetMapping()
    public String getString(@RequestParam String a, @RequestParam(required = false) String b) {

       if (b != null){
            return a + "  " + b;
        }else {
           return a;
       }
    }
}

