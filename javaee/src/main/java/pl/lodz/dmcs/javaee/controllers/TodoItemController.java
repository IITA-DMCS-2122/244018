package pl.lodz.dmcs.javaee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;
import pl.lodz.dmcs.javaee.services.TodoItemService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todo-items")
public class TodoItemController {

    @Autowired
    TodoItemService todoItemService;

    @GetMapping("/")
    public List<TodoItemEntity> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public TodoItemEntity getTodoItem(@PathVariable String id) {
        TodoItemEntity todoItem = null;
        try {
            todoItem = todoItemService.getTodoItem(Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("ERROR PARSING LONG");
        }
        return todoItem;
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

}
