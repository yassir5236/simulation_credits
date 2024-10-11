package org.example.credit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/storeForm2")
public class Form2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String telephone = request.getParameter("tel");

        session.setAttribute("email", email);
        session.setAttribute("telephone", telephone);

        System.out.println(email);
        System.out.println(telephone);
        System.out.println("donne2");

        response.sendRedirect("storeForm3.jsp");
    }

}

