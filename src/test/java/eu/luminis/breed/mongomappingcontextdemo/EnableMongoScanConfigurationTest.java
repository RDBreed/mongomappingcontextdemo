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
@ActiveProfiles("enable-mongo-scan")
public class EnableMongoScanConfigurationTest extends AbstractTest {

  @Autowired
  private MongoMappingContext mongoMappingContext;
  @Autowired
  private AbstractDocumentRepository abstractDocumentRepository;

  @Test
  public void testShouldHaveIncompleteMappingContext() {
    assertThat(mongoMappingContext.getPersistentEntities())
        .hasSize(1)
        .extracting(BasicPersistentEntity::getName)
        .containsExactlyInAnyOrder(AbstractDocument.class.getName());
  }

  @Test
  public void shouldFail(){
    List<AbstractDocument> documents = abstractDocumentRepository.findAll();
    assertThat(documents.get(0)).isInstanceOf(DocumentA.class);
  }

}
