package org.example.homeworks.hw_15_12_24.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentTruck {

    @BsonId
    ObjectId id = new ObjectId();
    String model;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate modelYear;

    @Override
    public String toString() {
        return "\nTruck: {" +
                " id = " + id + " |" +
                " model = '" + model + '\'' + "|" +
                " modelYear = " + modelYear +
                " } "
                + "\n-----------------------------------------------------------------------"
                + "------------------------ ";
    }
}
