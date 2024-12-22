package org.example.homeworks.hw_01_12_24.laptop.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;
import org.example.homeworks.hw_01_12_24.laptop.service.impl.LaptopServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.example.homeworks.hw_01_12_24.config.ObjectMapperProvider.OBJECT_MAPPER;

@WebServlet(urlPatterns = "/laptopServlet/*")
public class LaptopServlet extends HttpServlet {

    private static final LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE = new LaptopServiceImpl();

    //update ++
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reqReader = req.getReader();//id != 0

        LaptopDocument laptopDocument = OBJECT_MAPPER.readValue(reqReader, LaptopDocument.class);

        LAPTOP_SERVICE.update(laptopDocument);

        // Відправка відповіді клієнту
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Laptop updated successfully");

    }

    //findAll ++
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<LaptopDocument> allLaptop = LAPTOP_SERVICE.getAllLaptop();

        PrintWriter writer = resp.getWriter();

        writer.println(allLaptop);
    }

    //save ++
    /**
     * {
     * "model": "Yoga Slim 30",
     * "manufacturer": "Lenovo",
     * "releaseDate": "2025-05-20",
     * "ramCapacity": "64",
     * "ssdCapacity": "2048",
     * "processor": "Intel Core i7-15999"
     * }
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reqReader = req.getReader();//id = 0

        LaptopDocument laptopDocument = OBJECT_MAPPER.readValue(reqReader, LaptopDocument.class);

        LAPTOP_SERVICE.addLaptop(laptopDocument);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Laptop added successfully");
    }

    //delete by id ++
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        String pathInfo = req.getPathInfo();

        String id = pathInfo.substring(1);

        LAPTOP_SERVICE.deleteById(id);
    }
}
