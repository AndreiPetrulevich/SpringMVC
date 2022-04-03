package ru.gb.beans;

import org.springframework.context.annotation.Profile;
import ru.gb.MessageProvider;


@Profile("hello")
public class HelloSpringMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Spring";
    }
}
