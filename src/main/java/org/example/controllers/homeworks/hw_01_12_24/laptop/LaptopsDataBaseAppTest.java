package org.example.controllers.homeworks.hw_01_12_24.laptop;

import org.bson.types.ObjectId;
import org.example.controllers.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.controllers.homeworks.hw_01_12_24.laptop.json.LaptopJSON;
import org.example.controllers.homeworks.hw_01_12_24.laptop.service.LaptopService;
import org.example.controllers.homeworks.hw_01_12_24.laptop.service.impl.LaptopServiceImpl;

import java.time.LocalDate;

/**
 * --
 * 2. Розробіть інтерфейс, котрий міститиме необхідні операції над даними. Перелік операцій:
 * ++ a) додавання;
 * ++ б) перегляд за id;
 * ++ в) перегляд повного переліку;
 * г) видалення за id;
 * д) видалення повного переліку;
 * е) модифікація за id;
 * ++ 1) Delete notebook by processor
 * ++ 2) Delete notebook by RAM and SSD
 * ++ є) перегляд за моделлю;
 * ++ ж) перегляд за датою випуску;
 * ++ з) перегляд за об’ємом оперативної пам’яті та місткістю SSD;
 * ++ и) перегляд за процесором.
 * <p>
 * 3. Розробіть репозиторій на основі інтерфейсу (п. 2). Реалізуйте його методи.
 * 4. Побудуйте сервіс, що використовує отриманий у п. 3 репозиторій.
 * 5. Розробіть контролер для обробки запитів користувача.
 * 6. Продемонструйте розроблений проект у дії. Скористайтеся для надсилання запитів до сервера
 * API-клієнтом (Postman, Insomnia тощо). Формат тіла HTTP-запитів та відповідей сервера — JSON.
 * <p>
 * ++Додати сервісний слой !!!
 * <p>
 * ++1) Update Laptop in separate method
 */

public class LaptopsDataBaseAppTest {
    public static void main(String[] args) {

        ObjectId objectId = new ObjectId("673f9ed67369ec07f0ccbad3");

        LaptopDocument newLenovo1 = LaptopDocument.builder()
                .model("Yoga Slim 60")
                .manufacturer("Lenovo")
                .releaseDate(LocalDate.of(2025, 4, 20))
                .ramCapacity(64)
                .ssdCapacity(2048)
                .processor("Intel Core i9-1585G9")
                //.id(1)
                .build();

        LaptopDocument newLenovoD = LaptopDocument.builder()
                .model("Yoga Slim 20")
                .manufacturer("Lenovo")
                .releaseDate(LocalDate.of(2025, 4, 20))
                .ramCapacity(32)
                .ssdCapacity(2048)
                .processor("Intel Core i5-1585G9")
                //.id(objectId)
                .build();

        LaptopService<LaptopDocument, ObjectId> laptopServiceMongoDB = new LaptopServiceImpl();

        laptopServiceMongoDB.printAllLaptop();//++
        //laptopServiceMongoDB.addLaptop(newLenovoD);//++
        //System.out.println(laptopServiceMongoDB.findById(objectId));
        //laptopServiceMongoDB.filerByProcessor("Intel Core i5-1585G9");//++
        //laptopServiceMongoDB.deleteByRamAndSsd(32, 2048);//++
        //laptopServiceMongoDB.filterByReleaseDate(LocalDate.of(2025, 4, 20));//++
        //laptopServiceMongoDB.filterByTwoParam("model", "ramCapacity", "Yoga Slim 20", 32);//++
        //laptopServiceMongoDB.update(newLenovoD);//++

        LaptopJSON laptopJSON = new LaptopJSON();



    }
}
