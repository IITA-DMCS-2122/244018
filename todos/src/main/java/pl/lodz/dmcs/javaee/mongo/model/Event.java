package pl.lodz.dmcs.javaee.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Document
public class Event implements Serializable {
    @MongoId
    private String uuid;
    private String eventType;
    private Timestamp timestamp;
    private Details details;
}
