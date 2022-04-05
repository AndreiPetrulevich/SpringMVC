package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.MessageProvider;
import ru.gb.model.Message;
import ru.gb.repository.MessageRepository;

import java.util.List;

@Service // Бин отвечающий за бизнес логику
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message edit(Message message) {
        return messageRepository.edit(message);
    }

    public Message findById(Integer id) {
        return messageRepository.findById(id).orElse(new Message());
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public void deleteById(Integer id) {
        messageRepository.deleteById(id);
    }

    public Message getRandomMessage() {
        return Message.builder()
                .body(getMessageProvider().getMessage())
                .from("Randomizer")
                .to("browser")
                .build();
    }

    @Lookup
    public MessageProvider getMessageProvider() {
        return null;
    }
}
