package org.example.homeworks.hw_15_12_24.service.impl;

import org.example.homeworks.hw_15_12_24.dao.DriverDao;
import org.example.homeworks.hw_15_12_24.domain.Driver;
import org.example.homeworks.hw_15_12_24.domain.Truck;
import org.example.homeworks.hw_15_12_24.service.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {

    private DriverDao dao;

    @Override
    public List<Truck> getTrucksByDriverId(int driverId) {
        return dao.getTrucksForDriver(driverId);
    }

    @Override
    public void add(Driver driver) {
        dao.add(driver);
    }

    @Override
    public void update(Driver driver) {
        dao.update(driver);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Driver> getAll() {
        return dao.getAll();
    }

    @Override
    public Driver getById(int id) {
        return dao.getById(id);
    }
}
