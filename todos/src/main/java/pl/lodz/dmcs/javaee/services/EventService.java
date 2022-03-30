package pl.lodz.dmcs.javaee.services;

import pl.lodz.dmcs.javaee.mongo.model.Event;

public interface EventService {
    void addNewEvent(Event event);
}
