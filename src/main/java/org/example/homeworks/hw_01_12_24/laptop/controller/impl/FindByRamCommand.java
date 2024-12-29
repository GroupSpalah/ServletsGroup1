package org.example.homeworks.hw_01_12_24.laptop.controller.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.controller.Command;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;

import java.io.IOException;
import java.io.PrintWriter;

public class FindByRamCommand implements Command {

    private static LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE;

    public FindByRamCommand(LaptopService<LaptopDocument, ObjectId> laptopService) {
        LAPTOP_SERVICE = laptopService;
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pathInfo = request.getPathInfo();

        String ramCapacity = pathInfo.substring(1);//?

        int ram = Integer.parseInt(ramCapacity);

        PrintWriter writer = response.getWriter();

        LAPTOP_SERVICE
                .filerByRam(ram)
                .forEach(writer::println);
    }
}
