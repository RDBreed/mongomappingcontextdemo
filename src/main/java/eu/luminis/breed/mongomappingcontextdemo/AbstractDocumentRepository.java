package eu.luminis.breed.mongomappingcontextdemo;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbstractDocumentRepository extends MongoRepository<AbstractDocument, String> {

}
