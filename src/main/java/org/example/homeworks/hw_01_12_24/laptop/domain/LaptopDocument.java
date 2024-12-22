package org.example.homeworks.hw_01_12_24.laptop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
