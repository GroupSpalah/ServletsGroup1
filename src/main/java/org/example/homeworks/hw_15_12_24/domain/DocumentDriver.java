package org.example.homeworks.hw_15_12_24.domain;

/** Object from mongoDB:
 * {
 *   "_id": {
 *     "$oid": "6767fabe108ef15d893232ce"
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
 *       "_id": {
 *         "$oid": "6767fabe108ef15d893232ca"
 *       },
 *       "model": "Volvo FH",
 *       "modelYear": {
 *         "$date": "2015-05-10T00:00:00.000Z"
 *       }
 *     },
 *     {
 *       "_id": {
 *         "$oid": "6767fabe108ef15d893232cb"
 *       },
 *       "model": "Scania R450",
 *       "modelYear": {
 *         "$date": "2018-07-20T00:00:00.000Z"
 *       }
 *     },
 *     {
 *       "_id": {
 *         "$oid": "6767fabe108ef15d893232cc"
 *       },
 *       "model": "Volvo FM",
 *       "modelYear": {
 *         "$date": "2019-03-28T00:00:00.000Z"
 *       }
 *     },
 *     {
 *       "_id": {
 *         "$oid": "6767fabe108ef15d893232cd"
 *       },
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
        return "\nDriver: {" +
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
