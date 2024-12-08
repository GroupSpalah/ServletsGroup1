package org.example.homeworks.hw_01_12_24.laptop.service;

import java.time.LocalDate;
import java.util.List;

public interface LaptopService<T, ID> {
    void addLaptop(T laptop);

    T findById(ID id);

    void printAllLaptop();

    void filterByReleaseDate(LocalDate date);

    void filterByTwoParam(String firstParam, String secondParam,
                          Object firstValue, Object secondValue);

    void filterByModel(String value);

    void filerByProcessor(String value);

    void deleteById(String value);

    void deleteByProcessor(String value);

    void deleteByRamAndSsd(int firstParam, int secondParam);

    void update(T laptop);

    List<T> getAllLaptop();
}
