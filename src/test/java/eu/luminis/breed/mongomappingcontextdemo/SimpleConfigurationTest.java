package eu.luminis.breed.mongomappingcontextdemo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mapping.model.BasicPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("simple")
public class SimpleConfigurationTest  extends AbstractTest{

  @Autowired
  private MongoMappingContext mongoMappingContext;
  @Autowired
  private AbstractDocumentRepository abstractDocumentRepository;

  @Test
  public void testShouldHaveCompleteMappingContext() {
    assertThat(mongoMappingContext.getPersistentEntities()).hasSize(2)
        .extracting(BasicPersistentEntity::getName)
        .containsExactlyInAnyOrder(DocumentA.class.getName(), AbstractDocument.class.getName());
  }
  @Test
  public void shouldNotFail(){
    List<AbstractDocument> documents = abstractDocumentRepository.findAll();
    assertThat(documents.get(0)).isInstanceOf(DocumentA.class);
  }
}
