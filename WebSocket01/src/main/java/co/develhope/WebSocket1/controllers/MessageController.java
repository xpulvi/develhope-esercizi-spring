package co.develhope.WebSocket1.controllers;

import co.develhope.WebSocket1.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast-message")
    public ResponseEntity sendMessage(@RequestBody MessageDto messageDto){
        simpMessagingTemplate.convertAndSend("/topic/broadcast", messageDto);
        System.out.println(messageDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
