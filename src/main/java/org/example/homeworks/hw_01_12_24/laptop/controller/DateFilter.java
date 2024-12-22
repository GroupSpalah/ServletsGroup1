package org.example.homeworks.hw_01_12_24.laptop.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;
import org.example.homeworks.hw_01_12_24.laptop.service.impl.LaptopServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/laptopServlet/*")
public class DateFilter implements Filter {

    private static final LaptopService<LaptopDocument, ObjectId> LAPTOP_SERVICE = new LaptopServiceImpl();

    //http://localhost:9999/laptopServlet?startDate=2025-05-19
    //++
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String startDateParam = request.getParameter("startDate");

        PrintWriter writer = response.getWriter();

        if (startDateParam == null) {
            chain.doFilter(request, response);
            return;
        }

        if (!isValidDate(startDateParam)) {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.println("""
                    Invalid date format. Expected format: yyyy-MM-dd.
                    уууу — the year must start with 19 or 20 and have 4 digits.
                    MM — month from 01 to 12
                    dd — day from 01 to 31
                    """);
            return;
        }

        LocalDate startDate = LocalDate.parse(startDateParam);

        LAPTOP_SERVICE
                .filterByDateManufacturerDateGraterThan(startDate)
                .forEach(writer::println);
    }

    private static boolean isValidDate(String date) {
        String dateRegex = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
        return Pattern.matches(dateRegex, date);
    }
}
