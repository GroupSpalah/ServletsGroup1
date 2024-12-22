package org.example.homeworks.hw_01_12_24.laptop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.dao.LaptopDao;
import org.example.homeworks.hw_01_12_24.laptop.dao.impl.LaptopDaoImpl;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class LaptopServiceImpl implements LaptopService<LaptopDocument, ObjectId> {

    LaptopDao LAPTOP_DAO = new LaptopDaoImpl();

    public void addLaptop(LaptopDocument laptop) {
        LAPTOP_DAO.addLaptop(laptop);
    }

    public LaptopDocument findById(String id) {
        return LAPTOP_DAO.findById(id);
    }

    public void printAllLaptop() {
        LAPTOP_DAO.printAllLaptop();
    }

    public List<LaptopDocument> filterByReleaseDate(LocalDate date) {
        return LAPTOP_DAO.filterByReleaseDate(date);
    }

    public List<LaptopDocument> filterByDateManufacturerDateGraterThan(LocalDate date) {
        return LAPTOP_DAO.filterByDateManufacturerDateGraterThan(date);
    }

    public List<LaptopDocument> filterByTwoParam(String firstParam, String secondParam,
                                 Object firstValue, Object secondValue) {
        return LAPTOP_DAO.filterByTwoParam(firstParam, secondParam, firstValue, secondValue);
    }

    public List<LaptopDocument> filterByModel(String value) {
        return LAPTOP_DAO.filterByModel(value);
    }

    public List<LaptopDocument> filerByProcessor(String value) {
        return LAPTOP_DAO.filerByProcessor(value);
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
