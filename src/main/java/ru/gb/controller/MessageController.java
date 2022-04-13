package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Message;
import ru.gb.service.MessageService;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final MessageService messageService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        return "create-message";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Message message) {
        if (message.getId() == null) {
            messageService.save(message);
        } else {
            messageService.edit(message);
        }
        return "redirect:/message/all";
    }

    //localhost:8080/spring/message/{id}?random=true
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getMessageId(Model model, @PathVariable Integer id,
                               @RequestParam(name="random", defaultValue = "false", required = false) Boolean isRandom) {
        Message message;
        if (isRandom) {
            message = messageService.getRandomMessage();
        } else {
            message = messageService.findById(id);
        }

        model.addAttribute("message", message);
        return "message";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllMessages(Model model) {
        model.addAttribute("messages", messageService.findAll());
        return "message-list";
    }


    // localhost:8080/spring/message/delete?id=1
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id) {
        log.info("deleted: {}", id);
        messageService.deleteById(id);
        return "redirect:/message/all";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id) {
        model.addAttribute("message", messageService.findById(id));
        return "create-message";
    }
    /* @RequestMapping
    public String printMessage(Model model) {
        model.addAttribute("msg", messageProvider.getMessage());
        return "message";
    }

    @ModelAttribute("additional") // будет добавляться для всех методов в данном контроллере
    public String getAttribution() {
        return "attribute for all pages by annotation @ModelAttribute";
    }*/

}
