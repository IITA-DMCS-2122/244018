package pl.lodz.dmcs.javaee.model.entities;

import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Indexed
public class TodoItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Boolean isDone;
    @FullTextField
    private String description;
    @Column(unique = true)
    private String uuid;
    private LocalDateTime timestamp;

    public TodoItemEntity() {
        this.uuid = UUID.randomUUID().toString();
    }
}
