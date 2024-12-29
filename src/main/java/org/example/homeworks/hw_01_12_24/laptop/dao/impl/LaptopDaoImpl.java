package org.example.homeworks.hw_01_12_24.laptop.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.dao.LaptopDao;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.homeworks.hw_01_12_24.laptop.mongo_config.MongoClientManager.getMongoClient;
import static org.example.homeworks.hw_01_12_24.laptop.util.ConstantsUtil.*;

public class LaptopDaoImpl implements LaptopDao {

    private final MongoCollection<LaptopDocument> laptopsCollection;

    public LaptopDaoImpl() {
        MongoDatabase database = getMongoClient().getDatabase(DATABASE_NAME);
        this.laptopsCollection = database.getCollection(COLLECTION_NAME, LaptopDocument.class);
    }

    @Override
    public void addLaptop(LaptopDocument laptop) {
        InsertOneResult result = laptopsCollection.insertOne(laptop);
        System.out.println("Success! Inserted document id: " + result.getInsertedId());
    }

    @Override
    public LaptopDocument findById(String value) {

        ObjectId id = new ObjectId(value);

        return laptopsCollection.find(Filters.eq(ID, id)).first();
    }

    @Override
    public void printAllLaptop() {
        laptopsCollection
                .find()
                .into(new ArrayList<>())
                .forEach(System.out::println);
    }

    @Override
    public List<LaptopDocument> filterByReleaseDate(LocalDate date) {
        return filterByParam(RELEASE_DATE_JAVA, date);
    }

    @Override
    public List<LaptopDocument> filterByTwoParam(String firstParam, String secondParam, Object firstValue, Object secondValue) {
        List<LaptopDocument> laptops = new ArrayList<>();

        laptopsCollection
                .find(Filters.or(Filters.eq(firstParam, firstValue), Filters.eq(secondParam, secondValue)))
                .forEach(laptops::add);

        return laptops;
    }

    @Override
    public List<LaptopDocument> filterByModel(String value) {
        return filterByParam(MODEL, value);
    }

    @Override
    public List<LaptopDocument> filerByProcessor(String value) {
        return filterByParam(PROCESSOR, value);
    }

    @Override
    public List<LaptopDocument> filerByRam(int value) {
        return filterByParam(RAM_CAPACITY_JAVA, value);
    }

    private List<LaptopDocument> filterByParam(String param, Object value) {
        List<LaptopDocument> allLaptop = new ArrayList<>();

        laptopsCollection
                .find(Filters.eq(param, value))
                .forEach(allLaptop::add);

        return allLaptop;
    }

    @Override
    public List<LaptopDocument> filterByDateManufacturerDateGraterThan(LocalDate date) {

        List<LaptopDocument> filteredLaptops = new ArrayList<>();

        laptopsCollection
                .find(Filters.gte(RELEASE_DATE_JAVA, date))
                .forEach(filteredLaptops::add);

        return filteredLaptops;
    }

    @Override
    public void deleteByProcessor(String value) {
        laptopsCollection
                .deleteMany(
                        Filters.eq(PROCESSOR, value)
                );
    }

    @Override
    public void deleteById(String value) {

        ObjectId id = new ObjectId(value);

        laptopsCollection
                .deleteOne(
                        Filters.eq(ID, id)
                );
    }

    @Override
    public void deleteByRamAndSsd(int ram, int ssd) {
        laptopsCollection
                .deleteMany(Filters.and(Filters.eq(RAM_CAPACITY_JAVA, ram),
                        Filters.eq(SSD_CAPACITY_JAVA, ssd)));
    }

    @Override
    public void update(LaptopDocument laptopDocument) {
        laptopsCollection
                .replaceOne(Filters.eq(ID, laptopDocument.getId())
                        , laptopDocument);
    }

    @Override
    public List<LaptopDocument> getAllLaptop() {
        List<LaptopDocument> allLaptop = new ArrayList<>();

        laptopsCollection.find().forEach(allLaptop::add);
        return allLaptop;
    }
}
