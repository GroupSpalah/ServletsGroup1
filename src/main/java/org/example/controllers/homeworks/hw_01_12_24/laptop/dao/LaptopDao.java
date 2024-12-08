package org.example.controllers.homeworks.hw_01_12_24.laptop.dao;

import org.bson.types.ObjectId;
import org.example.controllers.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;

import java.time.LocalDate;
import java.util.List;

public interface LaptopDao {

    void addLaptop(LaptopDocument laptop);

    LaptopDocument findById(ObjectId id);

    void printAllLaptop();

    void filterByReleaseDate(LocalDate date);

    void filterByTwoParam(String firstParam, String secondParam,
                          Object firstValue, Object secondValue);

    void filterByModel(String value);

    void filerByProcessor(String value);

    void deleteById(String value);

    void deleteByProcessor(String value);

    void deleteByRamAndSsd(int ram, int ssd);

    void update(LaptopDocument laptop);

    //для переноса таблицы
    List<LaptopDocument> getAllLaptop();
}