package dev.dmgiangi.com.Swagger02.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
  @ApiOperation(value = "Welcome message generator", tags = "random-tag")
  @GetMapping("/")
  public String getWelcomeMessage() {
    return "hello there";
  }
}
