package org.example.controllers.homeworks.hw_01_12_24.laptop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.bson.codecs.pojo.annotations.BsonId;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDocument {

    @BsonId
    private ObjectId id;
    private String model;
    private String manufacturer;
    private LocalDate releaseDate;
    private int ramCapacity;
    private int ssdCapacity;
    private String processor;

    @Override
    public String toString() {
        return
                "\n| id=" + id +
                        " | model='" + model + '\'' +
                        " | manufacturer='" + manufacturer + '\'' +
                        " | releaseDate='" + releaseDate + '\'' +
                        " | RAMCapacity=" + ramCapacity +
                        " | SSDCapacity=" + ssdCapacity +
                        " | processor='" + processor + '\'' +
                        " |" +
                        "\n------------------------------------------------------------------------------------------------" +
                        "------------------------------------------------------------";
    }
}
