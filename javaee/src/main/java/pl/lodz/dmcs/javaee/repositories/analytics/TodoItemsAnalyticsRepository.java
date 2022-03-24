package pl.lodz.dmcs.javaee.repositories.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.dmcs.javaee.model.analytics.TodoItemAnalyticsEntity;

@Repository
public interface TodoItemsAnalyticsRepository extends JpaRepository<TodoItemAnalyticsEntity, Long> {
}
