package com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.Controller;

import com.example.ds2022_30442_muresan_ioanalexandru_assignment_2.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/application")
    @SendTo("/all/specific")
    public ChatMessage send(@Payload ChatMessage message) {
        //return message;
        System.out.println("got message: " + message.getUserFrom() + " was from and to is: " + message.getUserTo() + " and message is:   " + message.getText());
        //simpMessagingTemplate.convertAndSend("all/specific/" + message.getUserTo(), message.getText());
        return message;
    }

    @MessageMapping("/private")
    @SendTo("/all/specific")
    public ChatMessage sendRead(@Payload ChatMessage readMessage) {
        //simpMessagingTemplate.convertAndSend("", "/specific", readMessage);
        return readMessage;
    }
}