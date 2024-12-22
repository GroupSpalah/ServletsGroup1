package org.example.homeworks.hw_15_12_24.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Truck {
    int id;
    String model;
    int driverId;
    LocalDate modelYear;

    @Override
    public String toString() {
        return "\nTruck " + id + " {" +
                " id = " + id + " |" +
                " model = '" + model + '\'' + "|" +
                " driverId = " + driverId + "|" +
                " modelYear = " + modelYear +
                " } "
                + "\n-----------------------------------------------------------------------"
                + "------------------------ ";
    }
}
