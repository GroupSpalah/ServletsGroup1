package org.example.homeworks.hw_01_12_24.laptop.controller.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.controller.Command;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;

import java.io.IOException;
import java.io.PrintWriter;

import static org.example.homeworks.hw_01_12_24.laptop.util.ConstantsUtil.RAM_CAPACITY_JAVA;


//http://localhost:9999/laptopServlet/getByRam?ramCapacity=16
//++
public class FindByRamCommand implements Command {

    private static LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE;

    public FindByRamCommand(LaptopService<LaptopDocument, ObjectId> laptopService) {
        LAPTOP_SERVICE = laptopService;
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String ramCapacity = request.getParameter(RAM_CAPACITY_JAVA);

        int ram = Integer.parseInt(ramCapacity);

        PrintWriter writer = response.getWriter();

        LAPTOP_SERVICE
                .filerByRam(ram)
                .forEach(writer::println);
    }
}
