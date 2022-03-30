package pl.lodz.dmcs.javaee.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.lodz.dmcs.javaee.model.entities.TodoItemEntity;

import java.io.Serializable;

@Data
@Document
public class Details implements Serializable {
    private TodoItemEntity todoItem;
    private String status;
}
