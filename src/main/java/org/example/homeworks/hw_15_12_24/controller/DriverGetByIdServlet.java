package org.example.homeworks.hw_15_12_24.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.homeworks.hw_15_12_24.dao.CrudDao;
import org.example.homeworks.hw_15_12_24.dao.impl.CrudDocumentDriverDaoImpl;
import org.example.homeworks.hw_15_12_24.domain.DocumentDriver;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/driverDetails/*")

public class DriverGetByIdServlet extends HttpServlet {

    private static final CrudDao<DocumentDriver> DRIVER_SERVICE = new CrudDocumentDriverDaoImpl();

    //http://localhost:9999/driverDetails/6767fabe108ef15d893232ce    //++
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pathInfo = req.getPathInfo();

        String id = pathInfo.substring(1);

        DocumentDriver documentDriver = DRIVER_SERVICE.getById(id);

        PrintWriter writer = resp.getWriter();

        writer.println(documentDriver);
    }
}
