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

    private static final double TAUX_ANNUEL = 0.12;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String project = request.getParameter("project");
        String profession = request.getParameter("profession");
        String montantStr = request.getParameter("montant");
        String dureeStr = request.getParameter("duree");
        String mensualiteStr = request.getParameter("mensualite");


        double montant = Double.parseDouble(montantStr);
        int duree = Integer.parseInt(dureeStr);
        double mensualiteReceive = Double.parseDouble(mensualiteStr);


        double mensualiteCalculee = calculerMensualite(montant, duree, TAUX_ANNUEL);
        System.out.println("voila mensialite mensualiteReceive "+mensualiteReceive);
        System.out.println("voila mensialite mensualiteCalculee "+mensualiteCalculee);


        if (Math.abs(mensualiteReceive - mensualiteCalculee) > 0.01) {
            session.setAttribute("flashMessage", "La mensualité calculée est différente de la mensualité choisie. Mensualité enregistrer : " + mensualiteCalculee);
        } else {
            session.setAttribute("flashMessage", "La Mensualité enregistrée : " + mensualiteCalculee);
        }

        System.out.println("voila mensualiteReceive : " + mensualiteReceive);
        System.out.println("voila mensualiteCalculee : " + mensualiteCalculee);


        session.setAttribute("project", project);
        session.setAttribute("profession", profession);
        session.setAttribute("montant", montant);
        session.setAttribute("duree", duree);
        session.setAttribute("mensualite", mensualiteCalculee);


        System.out.println("donne1");

        response.sendRedirect("storeForm2.jsp");
    }


//    private double calculerMensualite(double capital, int dureeEnMois, double tauxAnnuel) {
//        double tauxMensuel = tauxAnnuel / 12;
//        return (capital * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeEnMois));
//    }


    private double calculerMensualite(double capital, int dureeEnMois, double tauxAnnuel) {
        double tauxMensuel = tauxAnnuel / 12;
        double mensualite = (capital * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeEnMois));
        return Math.round(mensualite * 100.0) / 100.0;
    }
}
