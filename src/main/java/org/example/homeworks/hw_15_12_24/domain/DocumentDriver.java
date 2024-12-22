package org.example.homeworks.hw_15_12_24.domain;

/** Object from mongoDB:
 * {
 *   "_id": {
 *     "$oid": "6767ece429a62e234ae06d5e"
 *   },
 *   "age": 30,
 *   "firstName": "John",
 *   "lastName": "Doe",
 *   "phone": {
 *     "number": 123456789
 *   },
 *   "qualification": "HIGH",
 *   "truckList": [
 *     {
 *       "model": "Volvo FH",
 *       "modelYear": {
 *         "$date": "2015-05-10T00:00:00.000Z"
 *       }
 *     },
 *     {
 *       "model": "Scania R450",
 *       "modelYear": {
 *         "$date": "2018-07-20T00:00:00.000Z"
 *       }
 *     },
 *     {
 *       "model": "Volvo FM",
 *       "modelYear": {
 *         "$date": "2019-03-28T00:00:00.000Z"
 *       }
 *     },
 *     {
 *       "model": "Truck New",
 *       "modelYear": {
 *         "$date": "2023-01-25T00:00:00.000Z"
 *       }
 *     }
 *   ]
 * }*/

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_15_12_24.Qualification;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DocumentDriver {

    @BsonId
    ObjectId id;
    String firstName;
    String lastName;
    int age;
    Qualification qualification;
    Phone phone;

    List<DocumentTruck> truckList;


    @Override
    public String toString() {
        return "Driver " + id + " {" +
                " id = " + id +
                "| firstName = '" + firstName + '\'' +
                "| lastName = '" + lastName + '\'' +
                "| age = " + age +
                "| qualification = " + qualification +
                "| \ntruckList = " + truckList +
                "}\n" + "\n------------------------------------------------------------------------"
                + "------------------------------";
    }

}
