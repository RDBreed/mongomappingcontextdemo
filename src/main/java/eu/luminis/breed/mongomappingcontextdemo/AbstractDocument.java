package eu.luminis.breed.mongomappingcontextdemo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "documentType")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = DocumentA.class, name = "documentA"),
})
@Document(collection = "documents")
public abstract class AbstractDocument {

  @Id
  private String id;
}
