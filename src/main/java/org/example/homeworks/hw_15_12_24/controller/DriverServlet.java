package org.example.homeworks.hw_15_12_24.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_15_12_24.dao.CrudDao;
import org.example.homeworks.hw_15_12_24.dao.impl.CrudDocumentDriverDaoImpl;
import org.example.homeworks.hw_15_12_24.domain.DocumentDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.example.homeworks.hw_01_12_24.config.ObjectMapperProvider.OBJECT_MAPPER;

@WebServlet(urlPatterns = "/driverServlet/*")
public class DriverServlet extends HttpServlet {

    private static final CrudDao<DocumentDriver> DRIVER_SERVICE = new CrudDocumentDriverDaoImpl();

    //update ??
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reqReader = req.getReader();//id != 0

        DocumentDriver documentDriver = OBJECT_MAPPER.readValue(reqReader, DocumentDriver.class);

        DRIVER_SERVICE.update(documentDriver);

        // Відправка відповіді клієнту
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Laptop updated successfully");

    }

    //findAll ++
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<DocumentDriver> allDrivers = DRIVER_SERVICE.getAll();

        PrintWriter writer = resp.getWriter();

        writer.println(allDrivers);
    }

    //save ++
    /**
     * {
     *   "age": 18,
     *   "firstName": "John",
     *   "lastName": "Doe Junior",
     *   "phone": {
     *     "number": 987654321
     *   },
     *   "qualification": "LOW",
     *   "truckList": [
     *     {
     *       "model": "Mersedes",
     *       "modelYear": "2020-10-10"
     *     },
     *     {
     *       "model": "Mitsubishi Lancer",
     *       "modelYear": "2018-07-20"
     *     },
     *     {
     *       "model": "BMW X6",
     *       "modelYear": "2019-03-28"
     *     }
     *   ]
     * }*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reqReader = req.getReader();//id = 0

        DocumentDriver documentDriver = OBJECT_MAPPER.readValue(reqReader, DocumentDriver.class);

        documentDriver
                .getTruckList()
                .forEach(documentTruck -> documentTruck.setId(new ObjectId()));

        DRIVER_SERVICE.add(documentDriver);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Laptop added successfully");
    }

    //delete by id ++
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        String pathInfo = req.getPathInfo();

        String id = pathInfo.substring(1);

        DRIVER_SERVICE.deleteById(id);
    }
}
