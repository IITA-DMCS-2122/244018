package pl.lodz.dmcs.javaee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;
import pl.lodz.dmcs.javaee.mongo.repositories.TodoItemsMongoRepository;
import pl.lodz.dmcs.javaee.repositories.analytics.TodoItemsAnalyticsRepository;
import pl.lodz.dmcs.javaee.repositories.entities.TodoItemsRepository;
import pl.lodz.dmcs.javaee.services.TodoItemService;
import pl.lodz.dmcs.javaee.utils.TodoItemConverter;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    private TodoItemsRepository todoItemsRepository;

    @Autowired
    private TodoItemsMongoRepository todoItemsMongoRepository;

    @Autowired
    private TodoItemsAnalyticsRepository todoItemAnalyticsRepository;

    @Override
    public void addNewTodoItem(TodoItemEntity todoItem) {
        todoItem.setTimestamp(LocalDateTime.now());
        todoItemsRepository.saveAndFlush(todoItem);
        todoItemAnalyticsRepository.save(TodoItemConverter.convertToAnalyticsEntity(todoItem));
        todoItemsMongoRepository.save(TodoItemConverter.convertToDocument(todoItem));
    }

    @Override
    public void deleteTodoItem(Long todoItemId) {
        todoItemsRepository.deleteById(todoItemId);
    }

    @Override
    public void editTodoItem(TodoItemEntity todoItem) throws Exception {
        TodoItemEntity item = todoItemsRepository.findById(todoItem.getId()).orElseThrow(Exception::new);
        item.setDescription(todoItem.getDescription());
        item.setTimestamp(LocalDateTime.now());
        item.setIsDone(todoItem.getIsDone());
        todoItemsRepository.saveAndFlush(item);
    }

    @Override
    public List<TodoItemEntity> getAllTodoItems() {
        return todoItemsRepository.findAll();
    }

    @Override
    public TodoItemEntity getTodoItem(Long todoItemId) throws Exception {
        return todoItemsRepository.findById(todoItemId).orElseThrow(Exception::new);
    }
}
