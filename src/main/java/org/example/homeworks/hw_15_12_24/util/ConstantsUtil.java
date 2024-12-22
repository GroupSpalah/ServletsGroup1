package org.example.homeworks.hw_15_12_24.util;

public class ConstantsUtil {
    static final String URL = "jdbc:mysql://localhost:3306/drivers";
    static final String USERNAME = "root";
    static final String PASSWORD = "af66s60dk29l97j;";

    public static final String DATABASE_NAME = "DriverDB";
    public static final String COLLECTION_NAME = "Drivers";

    public static final String INSERT_DRIVER =
            "INSERT INTO drivers (firstName, lastName, age, qualification) " +
                    "VALUES (?, ?, ?, ?)";
    public static final String UPDATE_DRIVER =
            "UPDATE drivers " +
                    "SET firstName=?, lastName=?, age=?, qualification=? " +
                    "WHERE driver_id=?";
    public static final String DELETE_DRIVER =
            "DELETE FROM drivers " +
                    "WHERE driver_id=?";
    public static final String SELECT_ALL_DRIVERS =
            "SELECT * " +
                    "FROM drivers";
    public static final String SELECT_DRIVER_BY_ID =
            "SELECT * " +
                    "FROM drivers " +
                    "WHERE driver_id=?";
    public static final String SELECT_TRUCKS_FOR_DRIVER =
            "SELECT * " +
                    "FROM trucks " +
                    "WHERE FK_driver_id=?";
    public static final String INSERT_TRUCK =
            "INSERT INTO trucks (model, model_year, FK_driver_id) " +
                    "VALUES (?, ?, ?)";
    public static final String UPDATE_TRUCK =
            "UPDATE trucks " +
                    "SET model=?, model_year=?, FK_driver_id=? " +
                    "WHERE truck_id=?";
    public static final String DELETE_TRUCK =
            "DELETE FROM trucks " +
                    "WHERE truck_id=?";
    public static final String SELECT_ALL_TRUCKS =
            "SELECT * " +
                    "FROM trucks";
    public static final String SELECT_TRUCK_BY_ID =
            "SELECT * " +
                    "FROM trucks " +
                    "WHERE truck_id=?";
}
