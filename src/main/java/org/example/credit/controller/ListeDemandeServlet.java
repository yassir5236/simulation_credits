//package org.example.credit.controller;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import jakarta.servlet.http.HttpServlet;
//import org.example.credit.model.CreditDemande;
//import org.example.credit.service.CreditDemandeService;
//import org.example.credit.service.impl.CreditDemandeServiceImpl;
//@WebServlet("/list")
//
//public class ListeDemandeServlet extends HttpServlet {
//    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();
//
//    @Override
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<CreditDemande> demandes = creditDemandeService.getAllDemandes();
//        System.out.println("### doGet Method Called ###");
//        System.out.println("Nombre de demandes récupérées: " + demandes.size());
//
//        if (demandes.isEmpty()) {
//            req.setAttribute("message", "Aucune demande de crédit trouvée.");
//        } else {
//            req.setAttribute("demandes", demandes);
//        }
//
//        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
//
//    }
//
//}












package org.example.credit.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.example.credit.model.CreditDemande;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;

@WebServlet("/list")
public class ListeDemandeServlet extends HttpServlet {

    @Inject
    private  CreditDemandeService creditDemandeService ;

//    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateParam = req.getParameter("date");
        String etatParam = req.getParameter("etat");
        LocalDate date = null;
        if (dateParam != null && !dateParam.isEmpty()) {
            date = LocalDate.parse(dateParam);
        }

        System.out.println(dateParam);
        System.out.println(etatParam);

        List<CreditDemande> demandes;

        if (dateParam != null || etatParam != null) {
            demandes = creditDemandeService.filterDemandes(date, etatParam);
        } else {
            demandes = creditDemandeService.getAllDemandes();
        }

        if (demandes == null || demandes.isEmpty()) {
            req.setAttribute("message", "Aucune demande de crédit trouvée.");
        } else {
            req.setAttribute("demandes", demandes);
        }

        System.out.println("### doGet Method Called ###");
        System.out.println("Nombre de demandes récupérées: " + demandes.size());

        if (demandes.isEmpty()) {
            req.setAttribute("message", "Aucune demande de crédit trouvée.");
        } else {
            req.setAttribute("demandes", demandes);
        }

        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
    }

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String dateStr = req.getParameter("date");
//        String etat = req.getParameter("etat");
//        LocalDate date = null;
//        if (dateStr != null && !dateStr.isEmpty()) {
//            date = LocalDate.parse(dateStr); // Vérifiez que le format est correct
//        }
//        System.out.println(date);
//
//        List<CreditDemande> demandes = creditDemandeService.filterDemandes(date, etat);
//        if (demandes.isEmpty()) {
//            req.setAttribute("message", "Aucune demande de crédit trouvée.");
//        } else {
//            req.setAttribute("demandes", demandes);
//        }
//
//        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
//    }
}
