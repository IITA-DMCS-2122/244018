package pl.lodz.dmcs.javaee.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TodoItemsRepository extends JpaRepository<TodoItemEntity, Long>, TodoItemIndexedRepository {
}
