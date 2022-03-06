package pl.lodz.dmcs.javaee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.dmcs.javaee.model.TodoItem;
import pl.lodz.dmcs.javaee.services.TodoItemService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todo-items")
public class TodoItemController {

    @Autowired
    TodoItemService todoItemService;

    @GetMapping("/")
    public List<TodoItem> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public TodoItem getTodoItem(@PathVariable String id) {
        TodoItem todoItem = null;
        try {
            todoItem = todoItemService.getTodoItem(Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("ERROR PARSING LONG");
        }
        return todoItem;
    }

    @PutMapping("/")
    public void addNewTodoItem(@RequestBody TodoItem todoItem) {
        todoItemService.addNewTodoItem(todoItem);
    }

    @PostMapping("/")
    public void editTodoItem(@RequestBody TodoItem todoItem) {
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
