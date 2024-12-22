package org.example.homeworks.hw_15_12_24.dao.impl;

import org.example.homeworks.hw_15_12_24.Qualification;
import org.example.homeworks.hw_15_12_24.dao.*;
import org.example.homeworks.hw_15_12_24.domain.Driver;
import org.example.homeworks.hw_15_12_24.domain.Truck;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.example.homeworks.hw_15_12_24.util.ConnectionUtil.getConnection;
import static org.example.homeworks.hw_15_12_24.util.ConstantsUtil.*;

public class DriverDaoImpl implements DriverDao {

    @SneakyThrows(SQLException.class)
    private void getPreparedStatement(String sqlExpression, Driver driver) {
        Connection connection = getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setString(1, driver.getFirstName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getAge());
        preparedStatement.setString(4, driver
                .getQualification()
                .toString()
                .toLowerCase(Locale.ROOT));
        int id = driver.getId();
        if (id != 0) {
            preparedStatement.setInt(5, id);
        }
        preparedStatement.executeUpdate();
    }

    public void add(Driver driver) {
        getPreparedStatement(INSERT_DRIVER, driver);
    }

    public void update(Driver driver) {
        getPreparedStatement(UPDATE_DRIVER, driver);
    }

    @SneakyThrows(SQLException.class)
    public void deleteById(int driverId) {
        Connection connection = getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRIVER);
        preparedStatement.setInt(1, driverId);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows(SQLException.class)
    private List<Driver> getDriverList(String sqlExpression, int filterValue) {

        List<Driver> drivers = new ArrayList<>();

        Connection connection = getConnection();

        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);

        if (filterValue != 0) {
            preparedStatement.setInt(1, filterValue);
        }

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("driver_id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            String qualificationValue = resultSet.getString("qualification");
            Qualification qualification = Qualification.valueOf(qualificationValue.toUpperCase());

            drivers.add(
                    Driver
                            .builder()
                            .id(id)
                            .firstName(firstName)
                            .lastName(lastName)
                            .age(age)
                            .qualification(qualification)
                            .truckList(getTrucksForDriver(id))
                            .build()
            );
        }
        return drivers;
    }

    public List<Driver> getAll() {
        return getDriverList(SELECT_ALL_DRIVERS, 0);
    }

    public Driver getById(int driverId) {
        return getDriverList(SELECT_DRIVER_BY_ID, driverId).getFirst();
    }

    public List<Truck> getTrucksForDriver(int driverId) {
        TruckDao truckDao = new TruckDaoImpl();
        return truckDao.getTrucksByValue(SELECT_TRUCKS_FOR_DRIVER, driverId);
    }
}