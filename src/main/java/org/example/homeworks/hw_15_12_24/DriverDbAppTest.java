package org.example.homeworks.hw_15_12_24;


import org.example.homeworks.hw_15_12_24.domain.DocumentDriver;
import org.example.homeworks.hw_15_12_24.domain.DocumentTruck;
import org.example.homeworks.hw_15_12_24.service.CrudService;
import org.example.homeworks.hw_15_12_24.service.impl.CrudDocumentDriverServiceImpl;

import java.time.LocalDate;

public class DriverDbAppTest {
    public static void main(String[] args) {

        CrudService<DocumentDriver> crudService = new CrudDocumentDriverServiceImpl();

        DocumentTruck newTruck = DocumentTruck
                .builder()
                //.id(68)
                .model("Truck New")
                .modelYear(LocalDate.of(2023, 1, 25))
                .build();

        DocumentDriver newDriver = DocumentDriver
                .builder()
                .firstName("New")
                .lastName("Driver")
                .age(33)
                .qualification(Qualification.MEDIUM)
                .build();

    }

    //перенос таблицы Drivers в MongoDB
/*    static void carryOver() {
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
                        .id(new ObjectId())
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
    }*/
}
