package pl.lodz.dmcs.javaee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.dmcs.javaee.mongo.model.Event;
import pl.lodz.dmcs.javaee.services.TodoItemService;

@RestController
@RequestMapping(path = "/api/v1/todo-items")
public class MessagePublisher {

    @Autowired
    private TodoItemService todoItemService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> createTodoItem(@RequestBody Event event) {
        todoItemService.addNewEvent(event);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> getAllTodoItemsCount() {
        return ResponseEntity.ok(todoItemService.getEventCount());
    }
}
