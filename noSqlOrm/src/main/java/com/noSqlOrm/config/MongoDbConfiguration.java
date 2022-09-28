package com.noSqlOrm.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collections;

@Configuration
public class MongoDbConfiguration extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return null;
    }
/*
    @Override
    public MongoClient mongoClient(){
        return ;
    }

    @Override
    protected Collections<String> getMappingBasePekeges(){
        return Collections.singleton("com.l");
    }
*/
}
