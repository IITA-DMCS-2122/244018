package pl.lodz.dmcs.javaee.services;

import pl.lodz.dmcs.javaee.model.TodoItem;

import java.util.List;

public interface TodoItemService {
    void addNewTodoItem(TodoItem todoItem);

    void deleteTodoItem(Long todoItemId) throws Exception;

    void editTodoItem(TodoItem todoItem) throws Exception;

    List<TodoItem> getAllTodoItems();

    TodoItem getTodoItem(Long todoItemId) throws Exception;
}
