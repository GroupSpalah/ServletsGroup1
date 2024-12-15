package org.example.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        String age = req.getParameter("age");

        int age1 = Integer.parseInt(age);

        PrintWriter writer = resp.getWriter();

        writer.println("My name is " + name + " with age " + age);
    }
}
