package ru.gb.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.gb.InjectFoodStuff;
import ru.gb.MessageProvider;

@Component
@Profile("like")
public class LikeMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String foodStuff;

    @Override
    public String getMessage() {
        return "I like " + foodStuff;
    }
}
