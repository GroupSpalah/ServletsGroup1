package org.example.homeworks.hw_01_12_24.laptop.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;
import org.example.homeworks.hw_01_12_24.laptop.service.impl.LaptopServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/laptopDetails/*")

public class LaptopGetByIdServlet extends HttpServlet {

    private static final LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE = new LaptopServiceImpl();

    //http://localhost:9999/laptopDetails/6749effcdfec7a0ca1e22457    //++
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pathInfo = req.getPathInfo();

        String id = pathInfo.substring(1);  // Вилучаємо ID з шляху

        LaptopDocument laptopDocument = LAPTOP_SERVICE.findById(id);

        PrintWriter writer = resp.getWriter();

        writer.println(laptopDocument);
    }
}
