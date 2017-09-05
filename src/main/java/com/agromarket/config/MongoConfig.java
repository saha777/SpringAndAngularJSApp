package com.agromarket.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Collection;

@Configuration
@EnableMongoRepositories(basePackages = "com.agromarket.repository")
public class MongoConfig extends AbstractMongoConfiguration{
    @Override
    protected Collection<String> getMappingBasePackages() {
        return Arrays.asList("com.agromarket");
    }

    @Override
    protected String getDatabaseName() {
        return "AgroDb";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
}
