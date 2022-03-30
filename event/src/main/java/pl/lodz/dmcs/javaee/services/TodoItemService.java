package pl.lodz.dmcs.javaee.services;

import pl.lodz.dmcs.javaee.mongo.model.Event;


public interface TodoItemService {
    void addNewEvent(Event event);
    int getEventCount();
}
