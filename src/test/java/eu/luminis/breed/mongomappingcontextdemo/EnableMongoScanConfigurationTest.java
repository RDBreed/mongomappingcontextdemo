package eu.luminis.breed.mongomappingcontextdemo;

import static org.assertj.core.api.Assertions.assertThat;

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
public class EnableMongoScanConfigurationTest {

  @Autowired
  private MongoMappingContext mongoMappingContext;

  @Test
  public void testShouldHaveIncompleteMappingContext() {
    assertThat(mongoMappingContext.getPersistentEntities())
        .hasSize(1)
        .extracting(BasicPersistentEntity::getName)
        .containsExactlyInAnyOrder(AbstractDocument.class.getName());
  }

}
