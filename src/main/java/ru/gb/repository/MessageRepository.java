package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.model.Message;

import java.util.*;

@Component
public class MessageRepository {

    List<Message> messages = new ArrayList<>();

    private int count;

    public Message save(Message message) {
        message.setId(count++);
        messages.add(message);
        return Message.builder()
                .id(message.getId())
                .from(message.getFrom())
                .to(message.getTo())
                .body(message.getBody())
                .build();
    }

    public Message edit(Message message) {
        return messages.set(message.getId(), message);
    }

    public Optional<Message> findById(Integer id) {
        if (id < messages.size()) {
            return Optional.of(messages.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Message> findAll() {
        return new ArrayList<>(messages);
    }

    public void deleteById(Integer id) {
        if (id < messages.size()) {
            messages.remove(id.intValue());
        }
    }
}
