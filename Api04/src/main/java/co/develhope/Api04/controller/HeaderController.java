package co.develhope.Api04.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;


@RestController
@RequestMapping("/header")
public class HeaderController {

    @GetMapping
    ResponseEntity <String> getUrlEndPort(@RequestHeader HttpHeaders headers){

        InetSocketAddress myHost = headers.getHost();

        String url = "l'hot is: " + myHost.getHostName() + " la porta e: " + myHost.getPort();
        return new ResponseEntity<String>(url, HttpStatus.OK);
    }


}
