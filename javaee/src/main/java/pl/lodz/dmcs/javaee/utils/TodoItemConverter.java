package pl.lodz.dmcs.javaee.utils;

import pl.lodz.dmcs.javaee.model.analytics.TodoItemAnalyticsEntity;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;
import pl.lodz.dmcs.javaee.mongo.model.TodoItem;

public class TodoItemConverter {

    public static TodoItem convertToDocument(TodoItemEntity todoItem) {
        TodoItem _todoItem = new TodoItem();
        _todoItem.setDescription(todoItem.getDescription());
        _todoItem.setTimestamp(todoItem.getTimestamp());
        _todoItem.setUuid(todoItem.getUuid());
        _todoItem.setIsDone(todoItem.getIsDone());
        return _todoItem;
    }

    public static TodoItemEntity convertToEntity(TodoItem todoItem) {
        TodoItemEntity _todoItem = new TodoItemEntity();
        _todoItem.setDescription(todoItem.getDescription());
        _todoItem.setTimestamp(todoItem.getTimestamp());
        _todoItem.setUuid(todoItem.getUuid());
        _todoItem.setIsDone(todoItem.getIsDone());
        return _todoItem;
    }

    public static TodoItemAnalyticsEntity convertToAnalyticsEntity(TodoItemEntity todoItem) {
        TodoItemAnalyticsEntity _todoItem = new TodoItemAnalyticsEntity();
        _todoItem.setDescription(todoItem.getDescription());
        _todoItem.setTimestamp(todoItem.getTimestamp());
        _todoItem.setUuid(todoItem.getUuid());
        _todoItem.setIsDone(todoItem.getIsDone());
        return _todoItem;
    }

    public static TodoItemAnalyticsEntity convertToAnalyticsEntity(TodoItem todoItem) {
        TodoItemAnalyticsEntity _todoItem = new TodoItemAnalyticsEntity();
        _todoItem.setDescription(todoItem.getDescription());
        _todoItem.setTimestamp(todoItem.getTimestamp());
        _todoItem.setUuid(todoItem.getUuid());
        _todoItem.setIsDone(todoItem.getIsDone());
        return _todoItem;
    }
}
