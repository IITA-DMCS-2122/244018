package pl.lodz.dmcs.javaee.repositories.entities;

import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;

import java.util.List;

public interface TodoItemIndexedRepository {
    List<TodoItemEntity> search(String query);
}
