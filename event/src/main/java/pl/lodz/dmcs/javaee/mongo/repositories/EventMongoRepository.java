package pl.lodz.dmcs.javaee.mongo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.dmcs.javaee.mongo.model.Event;

@Repository
public interface EventMongoRepository extends MongoRepository<Event, String> {

}
