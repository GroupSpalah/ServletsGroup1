package org.example.homeworks.hw_15_12_24.service;

import org.example.homeworks.hw_15_12_24.domain.Driver;
import org.example.homeworks.hw_15_12_24.domain.Truck;

import java.util.List;

public interface DriverService extends CrudService<Driver> {
    List<Truck> getTrucksByDriverId(int driverId);
}
