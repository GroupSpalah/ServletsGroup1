package org.example.homeworks.hw_15_12_24.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_15_12_24.dao.CrudDao;
import org.example.homeworks.hw_15_12_24.domain.DocumentDriver;

import java.util.ArrayList;
import java.util.List;

import static org.example.homeworks.hw_01_12_24.laptop.util.ConstantsUtil.ID;
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
        drivesCollection
                .replaceOne(Filters.eq(ID, driver.getId())
                        , driver);
    }

    @Override
    public void deleteById(String value) {

        ObjectId id = new ObjectId(value);

        drivesCollection
                .deleteOne(
                        Filters.eq(ID, id)
                );
    }

    @Override
    public List<DocumentDriver> getAll() {
        List<DocumentDriver> allLaptop = new ArrayList<>();

        drivesCollection.find().forEach(allLaptop::add);
        return allLaptop;
    }

    @Override
    public DocumentDriver getById(String value) {

        ObjectId id = new ObjectId(value);

        return drivesCollection.find(Filters.eq(ID, id)).first();
    }
}
