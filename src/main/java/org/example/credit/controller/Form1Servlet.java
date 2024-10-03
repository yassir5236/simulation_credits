package org.example.credit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/storeForm1")
public class Form1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Récupération des paramètres
        String project = request.getParameter("project");
        String profession = request.getParameter("profession");
        String montant = request.getParameter("montant");
        String duree = request.getParameter("duree");

        // Stockage dans la session
        session.setAttribute("project", project);
        session.setAttribute("profession", profession);
        session.setAttribute("montant", montant);
        session.setAttribute("duree", duree);
        System.out.println("donne1");

        // Redirection vers la page suivante
        response.sendRedirect("storeForm2.jsp");
    }
}
