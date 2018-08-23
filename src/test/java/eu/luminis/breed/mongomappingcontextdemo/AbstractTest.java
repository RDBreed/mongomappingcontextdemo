package eu.luminis.breed.mongomappingcontextdemo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bson.Document;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractTest {

  @Autowired
  private MongoClient mongoClient;

  @Before
  public void before() {
    MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> documents = database.getCollection("documents");
    Map<String, Object> values = new LinkedHashMap<>();
    values.put("_class", "DocumentA");
    documents.insertOne(new Document(values));
  }
}
