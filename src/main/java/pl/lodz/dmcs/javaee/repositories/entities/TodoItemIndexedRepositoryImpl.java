package pl.lodz.dmcs.javaee.repositories.entities;


import org.hibernate.search.mapper.orm.Search;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TodoItemIndexedRepositoryImpl implements TodoItemIndexedRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TodoItemEntity> search(String query) {
        return Search.session(entityManager)
                .search(TodoItemEntity.class)
                .where(f -> f.match()
                        .fields("description")
                        .matching(query)
                        .fuzzy())
                .fetchAllHits();
    }
}
