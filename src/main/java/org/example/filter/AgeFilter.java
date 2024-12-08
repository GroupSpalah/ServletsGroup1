package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/common/*")
public class AgeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

//        HttpServletRequest req1 = (HttpServletRequest) req;

        HttpServletResponse resp1 = (HttpServletResponse) resp;

        String strAge = req.getParameter("age");

        int age = Integer.parseInt(strAge);

        if (age < 18) {
            PrintWriter writer = resp1.getWriter();

            writer.println("Your age is less 18");

            resp1.setStatus(403);
        } else {
            filterChain.doFilter(req, resp);//to another filter or to servlet
        }
    }
}
