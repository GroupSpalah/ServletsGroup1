package org.example.homeworks.hw_15_12_24.service;

import org.example.homeworks.hw_15_12_24.domain.Truck;

import java.util.List;

public interface TruckService extends CrudService<Truck> {
    List<Truck> getTrucksByValue(String sqlExpression, int value);
}