package eu.luminis.breed.mongomappingcontextdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("enable-mongo-scan")
@Configuration
@EnableMongoRepositories(basePackages = {
    "eu.luminis.breed.mongomappingcontextdemo"
})
public class EnableMongoScanConfiguration {

}
