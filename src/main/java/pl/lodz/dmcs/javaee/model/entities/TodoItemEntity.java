package pl.lodz.dmcs.javaee.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class TodoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Boolean isDone;
    private String description;
    private String uuid;
    private LocalDateTime timestamp;

    public TodoItemEntity() {
        this.uuid = UUID.randomUUID().toString();
    }
}
