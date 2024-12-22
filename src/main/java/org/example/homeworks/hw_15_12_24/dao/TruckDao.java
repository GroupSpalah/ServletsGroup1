package org.example.homeworks.hw_15_12_24.dao;

import org.example.homeworks.hw_15_12_24.domain.Truck;

import java.util.List;

public interface TruckDao extends CrudDao<Truck> {
    List<Truck> getTrucksByValue(String sqlExpression, int value);
}
