package pl.lodz.dmcs.javaee.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
public class TodoItem {
    private String uuid;
    private Boolean isDone;
    private String description;
    private LocalDateTime timestamp;

    public TodoItem() {
        uuid = UUID.randomUUID().toString();
    }
}
