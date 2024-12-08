package org.example.controllers.homeworks.hw_01_12_24.laptop.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.controllers.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.controllers.homeworks.hw_01_12_24.laptop.service.LaptopService;
import org.example.controllers.homeworks.hw_01_12_24.laptop.service.impl.LaptopServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/laptopJson")
public class LaptopJSON extends HttpServlet {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE = new LaptopServiceImpl();

    //save --
    /**{
     "model": "Yoga Slim 30",
     "manufacturer": "Lenovo",
     "releaseDate": "2025-05-20",
     "ramCapacity": "64",
     "ssdCapacity": "2048",
     "processor": "Intel Core i7-15999"
     }*/
    @Override
    protected void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reqReader = req.getReader();

        LaptopDocument laptopDocument = OBJECT_MAPPER.readValue(reqReader, LaptopDocument.class);

        LAPTOP_SERVICE.addLaptop(laptopDocument);
    }

    //findAll ++
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<LaptopDocument> allLaptop = LAPTOP_SERVICE.getAllLaptop();

        PrintWriter writer = resp.getWriter();

        writer.println(allLaptop);
    }

    //get by id
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();

        ObjectId objectId = new ObjectId(line);

        String valueAsString = OBJECT_MAPPER.writeValueAsString(LAPTOP_SERVICE.findById(objectId));

        PrintWriter writer = resp.getWriter();

        writer.println(valueAsString);
    }

    //delete by id
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String line = req.getReader().readLine();

        LAPTOP_SERVICE.deleteById(line);
    }

}
