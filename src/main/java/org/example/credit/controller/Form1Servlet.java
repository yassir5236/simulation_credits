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

        String project = request.getParameter("project");
        String profession = request.getParameter("profession");
        String montant = request.getParameter("montant");
        String duree = request.getParameter("duree");
        String mensualite = request.getParameter("mensualite");

//        StringBuilder errorMessage = new StringBuilder();
//
//        if (project == null || project.trim().isEmpty()) {
//            errorMessage.append("Le projet est obligatoire. ");
//        }
//
//        if (profession == null || profession.trim().isEmpty()) {
//            errorMessage.append("La profession est obligatoire. ");
//        }
//
//        try {
//            double montantValue = Double.parseDouble(montant);
//            if (montantValue <= 0) {
//                errorMessage.append("Le montant doit être supérieur à 0. ");
//            }
//        } catch (NumberFormatException e) {
//            errorMessage.append("Le montant doit être un nombre valide. ");
//        }
//
//        // Validation du champ 'duree'
//        try {
//            int dureeValue = Integer.parseInt(duree);
//            if (dureeValue <= 0) {
//                errorMessage.append("La durée doit être supérieure à 0. ");
//            }
//        } catch (NumberFormatException e) {
//            errorMessage.append("La durée doit être un nombre valide. ");
//        }
//
//        try {
//            double mensualiteValue = Double.parseDouble(mensualite);
//            if (mensualiteValue <= 0) {
//                errorMessage.append("La mensualité doit être supérieure à 0. ");
//            }
//        } catch (NumberFormatException e) {
//            errorMessage.append("La mensualité doit être un nombre valide. ");
//        }
//
//        if (errorMessage.length() > 0) {
//            request.setAttribute("errorMessage", errorMessage.toString());
//            request.getRequestDispatcher("storeForm1.jsp").forward(request, response);
//            return;
//        }

        session.setAttribute("project", project);
        session.setAttribute("profession", profession);
        session.setAttribute("montant", montant);
        session.setAttribute("duree", duree);
        session.setAttribute("mensualite", mensualite);

        System.out.println(project);
        System.out.println(profession);
        System.out.println(montant);
        System.out.println(duree);
        System.out.println(mensualite);
        System.out.println("donne1");

        response.sendRedirect("storeForm2.jsp");
    }
}
