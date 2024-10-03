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

        // Récupération des paramètres
        String email = request.getParameter("email");
        String telephone = request.getParameter("tel");

        // Stockage dans la session
        session.setAttribute("email", email);
        session.setAttribute("telephone", telephone);

        // Redirection vers la page suivante
        response.sendRedirect("storeForm3.jsp");
                System.out.println("donne2");

    }
}
