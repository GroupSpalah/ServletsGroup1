package org.example.homeworks.hw_15_12_24.dao;

import org.example.homeworks.hw_15_12_24.domain.Driver;
import org.example.homeworks.hw_15_12_24.domain.Truck;

import java.util.List;

public interface DriverDao extends CrudDao<Driver> {
    List<Truck> getTrucksForDriver(int driverId);
}
