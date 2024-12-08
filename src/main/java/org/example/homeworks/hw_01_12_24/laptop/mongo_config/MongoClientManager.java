package org.example.homeworks.hw_01_12_24.laptop.mongo_config;

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
        //initClient();//для инициализации при загрузке класса в JVM. Может бить излишним, если клиент не всегда требуется при работе программы.

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutting down MongoClient...");
            closeClient();
        }));
    }

    public static MongoClient getMongoClient() {

        if (mongoClient == null) {
            //synchronized (MongoClientManager.class) { // потрібно для роботи клієнта в багатопотоковому середовищі
            //    if (mongoClient == null) {
                    initClient();
            //    }
            //}
        }
        return mongoClient;
    }

    public static void initClient() {
        try {               //Plain Old Java Object
            CodecRegistry POJO_CODEC_REGISTRY = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            ); //PojoCodecProvider используется для автоматического преобразования
            // объектов java в тип bson и обратно (сериализация и десериализация).
            // CodecRegistry управляет коллекцией кодеков.
            // Он исполняет роль реестра, который сохраняет и предоставляет соответствующий кодек для конкретного типа.


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
