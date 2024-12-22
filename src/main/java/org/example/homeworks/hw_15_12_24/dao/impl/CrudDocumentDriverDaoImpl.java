package org.example.homeworks.hw_15_12_24.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_15_12_24.dao.CrudDao;
import org.example.homeworks.hw_15_12_24.domain.DocumentDriver;

import java.util.ArrayList;
import java.util.List;

import static org.example.homeworks.hw_15_12_24.mongo_config.MongoClientManager.getMongoClient;
import static org.example.homeworks.hw_15_12_24.util.ConstantsUtil.*;

public class CrudDocumentDriverDaoImpl implements CrudDao<DocumentDriver> {

    private final MongoCollection<DocumentDriver> drivesCollection;


    public CrudDocumentDriverDaoImpl() {
        MongoDatabase database = getMongoClient().getDatabase(DATABASE_NAME);
        this.drivesCollection = database.getCollection(COLLECTION_NAME, DocumentDriver.class);
    }

    @Override
    public void add(DocumentDriver driver) {
        InsertOneResult result = drivesCollection.insertOne(driver);
        System.out.println("Success! Inserted document id: " + result.getInsertedId());
    }

    @Override
    public void update(DocumentDriver driver) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<DocumentDriver> getAll() {
        List<DocumentDriver> allLaptop = new ArrayList<>();

        drivesCollection.find().forEach(allLaptop::add);
        return allLaptop;
    }

    @Override
    public DocumentDriver getById(int id) {
        return null;
    }
}
