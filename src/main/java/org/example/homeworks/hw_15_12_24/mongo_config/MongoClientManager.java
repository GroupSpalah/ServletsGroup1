package org.example.homeworks.hw_15_12_24.mongo_config;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoClientManager {

    private static final Logger log = LoggerFactory.getLogger(MongoClientManager.class);
    private static volatile MongoClient mongoClient;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutting down MongoClient...");
            closeClient();
        }));
    }

    public static MongoClient getMongoClient() {

        if (mongoClient == null) {
            initClient();
        }
        return mongoClient;
    }

    public static void initClient() {
        try {               //Plain Old Java Object
            CodecRegistry POJO_CODEC_REGISTRY = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(POJO_CODEC_REGISTRY)
                    .build();

            mongoClient = MongoClients.create(settings);
            log.info("MongoClient initialized successfully.");

        } catch (Exception e) {
            log.error("Failed to create MongoClient:", e);
            throw new RuntimeException("MongoClient initialization failed", e);
        }
    }

    private static void closeClient() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
                log.info("MongoClient closed successfully");
            } catch (Exception e) {
                log.error("Error while closing MongoClient: ", e);
            }
        }
    }
}
