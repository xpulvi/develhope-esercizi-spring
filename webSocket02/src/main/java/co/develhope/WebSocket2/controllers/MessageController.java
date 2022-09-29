package co.develhope.WebSocket2.controllers;

import co.develhope.WebSocket2.dto.ClientMessageDto;
import co.develhope.WebSocket2.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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

    @MessageMapping("/client-message")
    @SendTo("/topic/broadcast")
    public MessageDto messageHandle(ClientMessageDto clientMessageDto){
        System.out.println(clientMessageDto);
        return new MessageDto(clientMessageDto.getClientName(), clientMessageDto.getClientAlert(), clientMessageDto.getClientMsg());
    }

}
