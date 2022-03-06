package pl.lodz.dmcs.javaee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.dmcs.javaee.model.TodoItem;
import pl.lodz.dmcs.javaee.repositories.TodoItemsRepository;
import pl.lodz.dmcs.javaee.services.TodoItemService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    private TodoItemsRepository todoItemsRepository;

    @Override
    public void addNewTodoItem(TodoItem todoItem) {
        todoItemsRepository.saveAndFlush(todoItem);
    }

    @Override
    public void deleteTodoItem(Long todoItemId) {
        todoItemsRepository.deleteById(todoItemId);
    }

    @Override
    public void editTodoItem(TodoItem todoItem) throws Exception {
        TodoItem item = todoItemsRepository.findById(todoItem.getId()).orElseThrow(Exception::new);
        item.setDescription(todoItem.getDescription());
        item.setTimestamp(LocalDateTime.now());
        item.setIsDone(todoItem.getIsDone());
        todoItemsRepository.saveAndFlush(item);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemsRepository.findAll();
    }

    @Override
    public TodoItem getTodoItem(Long todoItemId) throws Exception {
        return todoItemsRepository.findById(todoItemId).orElseThrow(Exception::new);
    }
}
