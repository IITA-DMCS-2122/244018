package pl.lodz.dmcs.javaee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.dmcs.javaee.model.TodoItem;

@Repository
public interface TodoItemsRepository extends JpaRepository<TodoItem, Long> {
}
