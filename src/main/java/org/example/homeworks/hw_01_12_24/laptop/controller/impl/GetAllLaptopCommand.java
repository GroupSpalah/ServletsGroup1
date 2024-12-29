package org.example.homeworks.hw_01_12_24.laptop.controller.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.controller.Command;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//http://localhost:9999/laptopServlet
//++
public class GetAllLaptopCommand implements Command {

    private static LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE;

    public GetAllLaptopCommand(LaptopService<LaptopDocument, ObjectId> laptopService) {
        LAPTOP_SERVICE = laptopService;
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<LaptopDocument> allLaptop = LAPTOP_SERVICE.getAllLaptop();

        PrintWriter writer = response.getWriter();

        writer.println(allLaptop);

    }
}
