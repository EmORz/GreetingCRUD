package com.example.GreetingCRUD;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageTypeController {

    private MessageTypeRepository messageTypeRepository;

    public MessageTypeController(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }

    @GetMapping("/greeting-types")
    public String listGreetingTypes(Model model){
        model.addAttribute("greetingTypes", messageTypeRepository.findAll());
        return "greeting-type-list";
    }

    @GetMapping("/greeting-types/new")
    public String createGreetingType(Model model){
        model.addAttribute("greetingType", new MessageType());
        return "greeting-type-form";
    }

    @PostMapping("/greeting-types")
    public String saveGreetingType(MessageType messageType){
        messageTypeRepository.save(messageType);
        return "redirect:/greeting-types";
    }


}
