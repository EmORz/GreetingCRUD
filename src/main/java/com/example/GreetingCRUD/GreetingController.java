package com.example.GreetingCRUD;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    private GreetingRepository greetingRepository;
    private MessageTypeRepository messageTypeRepository;

    public GreetingController(GreetingRepository greetingRepository, MessageTypeRepository messageTypeRepository) {
        this.greetingRepository = greetingRepository;
        this.messageTypeRepository = messageTypeRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("greetings", greetingRepository.findAll());
        return "index";
    }
    @GetMapping("/greetings/new")
    public String createGreeting(Model model){
        model.addAttribute("greeting", new Greeting());
        model.addAttribute("greetingTypes", messageTypeRepository.findAll());
        return "greeing-form";
    }
    @PostMapping("/greetings")
    public String saveGreeting(@ModelAttribute Greeting greeting){
        greetingRepository.save(greeting);
        return "redirect:/";
    }
}
