package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.domain.Email;
import org.example.domain.Person;
import org.example.domain.Phone;


import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Email email1 = Email
                .builder()
                .id(2)
                .name("ukr.net")
                .build();

        Email email2 = Email
                .builder()
                .id(3)
                .name("mail.ua")
                .build();

        Phone phone = Phone
                .builder()
                .id(4)
                .number("095")
                .build();

        Person person = Person
                .builder()
                .date(LocalDate.now())
                .age(25)
                .emails(List.of(email1, email2))
                .phone(phone)
                .build();

        email1.setPerson(person);
        email2.setPerson(person);
        phone.setPerson(person);

        String json = OBJECT_MAPPER.writeValueAsString(person);

        resp.getWriter().println(json);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        Person person = OBJECT_MAPPER.readValue(reader, Person.class);

        System.out.println(person);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        Person person = OBJECT_MAPPER.readValue(reader, Person.class);

        person.getEmails().forEach(email -> email.setPerson(person));

        person.getPhone().setPerson(person);

        System.out.println(person);
    }
}

/**
 * save(ids = 0) - POST
 * GET Person by ids != 0 -> json
 * update(ids != 0) - PUT
 */

/**
 * Author(List<Ad> ads)
 *
 * Ad(ManyToOne -> Author)
 */