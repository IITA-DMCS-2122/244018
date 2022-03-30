package pl.lodz.dmcs.javaee.model.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class TodoItemEntity implements Serializable {
    private Long id;
    private Boolean isDone;
    private String description;
    private String uuid;
    private LocalDateTime timestamp;
}
