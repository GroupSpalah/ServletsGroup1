package org.example.homeworks.hw_01_12_24.laptop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Command {

    void process(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
