package com.example.GreetingCRUD;

import org.springframework.stereotype.Controller;

@Controller
public class MessageTypeController {

    private MessageTypeRepository messageTypeRepository;

    public MessageTypeController(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }
}
