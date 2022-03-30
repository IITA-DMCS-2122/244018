package pl.lodz.dmcs.javaee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.dmcs.javaee.mongo.model.Event;
import pl.lodz.dmcs.javaee.repositories.analytics.TodoItemsAnalyticsRepository;
import pl.lodz.dmcs.javaee.repositories.entities.TodoItemsRepository;
import pl.lodz.dmcs.javaee.services.EventService;
import pl.lodz.dmcs.javaee.utils.TodoItemConverter;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private TodoItemsRepository todoItemsRepository;

    @Autowired
    private TodoItemsAnalyticsRepository todoItemAnalyticsRepository;

    @Override
    public void addNewEvent(Event event) {
        todoItemsRepository.saveAndFlush(event.getDetails().getTodoItem());
        todoItemAnalyticsRepository.save(TodoItemConverter.convertToAnalyticsEntity(event.getDetails().getTodoItem()));
    }
}
