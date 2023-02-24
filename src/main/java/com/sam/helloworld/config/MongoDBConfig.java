package com.sam.helloworld.config;

import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;


@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoURI;

    @Value("${spring.data.mongodb.database}")
    private String db;

    @Override
    protected String getDatabaseName() {
        return db;
    }

    @Bean
    @Override
    public MongoClient mongoClient(){
        MongoClient mongoClient = MongoClients.create(mongoURI);
        ListDatabasesIterable<Document> databases = mongoClient.listDatabases();
        databases.forEach(System.out::println);
        return mongoClient;
    }



}
