package org.example.homeworks.hw_15_12_24;


import org.example.homeworks.hw_15_12_24.dao.*;
import org.example.homeworks.hw_15_12_24.dao.impl.*;
import org.example.homeworks.hw_15_12_24.domain.*;
import org.example.homeworks.hw_15_12_24.util.ConnectionUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DriverDbAppTest {
    public static void main(String[] args) {

        TruckDao truckDao = new TruckDaoImpl();
        DriverDao driverDao = new DriverDaoImpl();

        Truck newTruck = Truck
                .builder()
                //.id(68)
                .model("Truck New")
                .driverId(1)
                .modelYear(LocalDate.of(2023, 1, 25))
                .build();

        Driver newDriver = Driver
                .builder()
                .id(33)
                .firstName("New")
                .lastName("Driver")
                .age(33)
                .qualification(Qualification.MEDIUM)
                .build();
        //truckDao.add(newTruck);
        //truckDao.update(newTruck);
        //truckDao.deleteById(67);
        //truckDao.getAll().forEach(System.out::println);
        //System.out.println(truckDao.getById(5));
        //driverDao.add(newDriver);
        //driverDao.update(newDriver);
        //driverDao.deleteById(2);
        //driverDao.getAll().forEach(System.out::println);
        //System.out.println(driverDao.getById(1));
        //driverDao.getTrucksForDriver(1).forEach(System.out::println);

        carryOver();
        ConnectionUtil.disconnect();
    }

    //перенос таблицы Drivers в MongoDB
    static void carryOver() {
        DriverDao driverDao = new DriverDaoImpl();
        CrudDao<DocumentDriver> driverCrudDao = new CrudDocumentDriverDaoImpl();

        List<Driver> driverList = driverDao.getAll();

        driverList.forEach(i -> {

            int id = i.getId();
            String firstName = i.getFirstName();
            String lastName = i.getLastName();
            int age = i.getAge();
            Qualification qualification = i.getQualification();
            Phone phone = new Phone();
            phone.setNumber(123456789);

            List<Truck> truckList = driverDao.getTrucksForDriver(id);

            List<DocumentTruck> documentTruckList = new ArrayList<>();

            truckList.forEach(truck -> {
                String model = truck.getModel();
                LocalDate modelYear = truck.getModelYear();

                DocumentTruck truckDoc = DocumentTruck
                        .builder()
                        .model(model)
                        .modelYear(modelYear)
                        .build();

                documentTruckList.add(truckDoc);
            });

            DocumentDriver driver = DocumentDriver
                            .builder()
                            .firstName(firstName)
                            .lastName(lastName)
                            .age(age)
                            .phone(phone)
                            .qualification(qualification)
                            .truckList(documentTruckList)
                            .build();

            driverCrudDao.add(driver);
        });
    }
}
