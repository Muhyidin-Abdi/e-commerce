package dev.muhidin.ecommerce.Message;

import dev.muhidin.ecommerce.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;
    public List<Message> getALLMessage() {
        return  messageRepo.findAll();
    }
    public Message getMessageById(long id) {
        return messageRepo.findById(id).orElseThrow(()-> new RuntimeException("Message with "+ id + " is not Found"));
    }

    public void CreateMessage(Message message) {
        messageRepo.save(message);
    }

    public void UpdateMessage(Message message) {
        messageRepo.findById(message.getId()).orElseThrow(()-> new RuntimeException("Message with "+ message.getId() + " is not Found"));
        messageRepo.save(message);
    }
    public void DeleteMessage(long id) {
        messageRepo.findById(id).orElseThrow(()-> new RuntimeException("Message with "+ id + " is not Found"));
        messageRepo.deleteById(id);
    }
}
