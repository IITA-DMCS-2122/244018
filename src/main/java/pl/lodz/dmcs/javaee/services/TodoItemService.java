package pl.lodz.dmcs.javaee.services;

import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;

import java.util.List;

public interface TodoItemService {
    void addNewTodoItem(TodoItemEntity todoItem);

    void deleteTodoItem(Long todoItemId) throws Exception;

    void editTodoItem(TodoItemEntity todoItem) throws Exception;

    List<TodoItemEntity> getAllTodoItems();

    TodoItemEntity getTodoItem(Long todoItemId) throws Exception;

    List<TodoItemEntity> getAllTodoItemsBySearchPhrase(String searchPhrase);
}
