package com.lji.mwohaemukji.config;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoConfig
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/16
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.lji.mwohaemukji.repository.mongo", mongoTemplateRef = "mwoMongoTemplate")
@EnableMongoAuditing
public class MongoConfig {

    @Bean
    public MongoTemplate mwoMongoTemplate(MongoClient mongoClient) {
        MongoDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(mongoClient, "mwo");
        return new MongoTemplate(factory);
    }
}
