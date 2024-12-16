package dev.muhidin.ecommerce.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ContentController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send/message")
    public String  sendMessage(Message message, Model model) {
        messageService.CreateMessage(message);
        model.addAttribute("verified","Your message was sent successfully");
        return "/ContactUS";
    }

}
