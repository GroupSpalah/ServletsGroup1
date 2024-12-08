package org.example.controllers.homeworks.hw_01_12_24.laptop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.example.controllers.homeworks.hw_01_12_24.laptop.dao.LaptopDao;
import org.example.controllers.homeworks.hw_01_12_24.laptop.dao.mongoDbDAOimpl.LaptopDaoImpl;
import org.example.controllers.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.controllers.homeworks.hw_01_12_24.laptop.service.LaptopService;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class LaptopServiceImpl implements LaptopService<LaptopDocument, ObjectId> {

    LaptopDao LAPTOP_DAO = new LaptopDaoImpl();

    public void addLaptop(LaptopDocument laptop) {
        LAPTOP_DAO.addLaptop(laptop);
    }

    public LaptopDocument findById(ObjectId id) {
        return LAPTOP_DAO.findById(id);
    }

    public void printAllLaptop() {
        LAPTOP_DAO.printAllLaptop();
    }

    public void filterByReleaseDate(LocalDate date) {
        LAPTOP_DAO.filterByReleaseDate(date);
    }

    public void filterByTwoParam(String firstParam, String secondParam,
                                 Object firstValue, Object secondValue) {
        LAPTOP_DAO.filterByTwoParam(firstParam, secondParam, firstValue, secondValue);
    }

    public void filterByModel(String value) {
        LAPTOP_DAO.filterByModel(value);
    }

    public void filerByProcessor(String value) {
        LAPTOP_DAO.filerByProcessor(value);
    }

    @Override
    public void deleteById(String value) {
        LAPTOP_DAO.deleteById(value);
    }

    public void deleteByProcessor(String value) {
        LAPTOP_DAO.deleteByProcessor(value);
    }

    public void deleteByRamAndSsd(int firstParam, int secondParam) {
        LAPTOP_DAO.deleteByRamAndSsd(firstParam, secondParam);
    }

    public void update(LaptopDocument laptop) {
        LAPTOP_DAO.update(laptop);
    }

    public List<LaptopDocument> getAllLaptop() {
        return LAPTOP_DAO.getAllLaptop();
    }
}
