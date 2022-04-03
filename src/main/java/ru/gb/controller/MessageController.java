package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.MessageProvider;

@Controller
@RequestMapping("/message") //
public class MessageController {

    private final MessageProvider messageProvider;

    @Autowired
    public MessageController(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }


    @RequestMapping
    public String printMessage(Model model) {
        model.addAttribute("msg", messageProvider.getMessage());
        return "message";
    }
}
