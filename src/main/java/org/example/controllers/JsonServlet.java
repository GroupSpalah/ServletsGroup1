package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Man;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/json")
public class JsonServlet extends HttpServlet {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();

        Man man = OBJECT_MAPPER.readValue(reader, Man.class);

        System.out.println(man);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Man ken = Man
                .builder()
                .name("Ken")
                .age(35)
                .build();

        String json = OBJECT_MAPPER.writeValueAsString(ken);

        PrintWriter writer = resp.getWriter();

        writer.println(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
