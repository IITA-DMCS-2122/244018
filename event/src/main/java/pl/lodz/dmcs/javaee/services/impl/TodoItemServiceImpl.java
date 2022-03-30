package pl.lodz.dmcs.javaee.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.dmcs.javaee.mongo.model.Event;
import pl.lodz.dmcs.javaee.mongo.repositories.EventMongoRepository;
import pl.lodz.dmcs.javaee.services.TodoItemService;

@Service
@RequiredArgsConstructor
public class TodoItemServiceImpl implements TodoItemService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private EventMongoRepository eventMongoRepository;

    @Override
    public void addNewEvent(Event event) {
        eventMongoRepository.save(event);
        rabbitTemplate.convertAndSend("244018", event);
    }

    @Override
    public int getEventCount() {
        return eventMongoRepository.findAll().size();
    }
}
