package pl.lodz.dmcs.javaee.controllers;

import org.apache.coyote.Response;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;
import pl.lodz.dmcs.javaee.mongo.model.Event;
import pl.lodz.dmcs.javaee.services.EventService;
import pl.lodz.dmcs.javaee.services.TodoItemService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todo-items")
public class TodoItemController {

    @Autowired
    TodoItemService todoItemService;

    @Autowired
    EventService eventService;

    @GetMapping("/")
    public ResponseEntity<List<TodoItemEntity>> getAllTodoItems() {
        return ResponseEntity.ok(todoItemService.getAllTodoItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItemEntity> getTodoItem(@PathVariable String id) {
        TodoItemEntity todoItem = null;
        try {
            todoItem = todoItemService.getTodoItem(Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("ERROR PARSING LONG");
        }
        return ResponseEntity.ok(todoItem);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<TodoItemEntity>> searchTodoItem(@PathVariable String search) {
        return ResponseEntity.ok(todoItemService.getAllTodoItemsBySearchPhrase(search));
    }

    @PutMapping("/")
    public void addNewTodoItem(@RequestBody TodoItemEntity todoItem) {
        todoItemService.addNewTodoItem(todoItem);
    }

    @PostMapping("/")
    public void editTodoItem(@RequestBody TodoItemEntity todoItem) {
        try {
            todoItemService.editTodoItem(todoItem);
        } catch (Exception e) {
            System.out.println("ERROR DURING EDIT OPERATION");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable String id) {
        try {
            todoItemService.deleteTodoItem(Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("ERROR PARSING LONG");
        }
    }

    @RabbitListener(queues = "244018")
    public void receiveMessage(Event event) {
        eventService.addNewEvent(event);
        System.out.println("Received event: " + event);
    }



}
