package dev.muhidin.ecommerce.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send/message")
    public String  sendMessage(Message message, Model model) {
        messageService.CreateMessage(message);
        model.addAttribute("verified", "Your message was sent successfully");
        return "/ContactUS";
    }
    @GetMapping("/messages")
    public String showMessages(Model model) {
        List<Message> messages = messageService.getALLMessage();
        model.addAttribute("messagesList", messages);
        return "AdminHomePage"; // This corresponds to your Thymeleaf template name.
    }
}



