package org.example.credit.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import org.example.credit.model.CreditDemande;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;
@WebServlet("/list")

public class ListeDemandeServlet extends HttpServlet {
    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CreditDemande> demandes = creditDemandeService.getAllDemandes();
        System.out.println("### doGet Method Called ###");
        System.out.println("Nombre de demandes récupérées: " + demandes.size());

        if (demandes.isEmpty()) {
            req.setAttribute("message", "Aucune demande de crédit trouvée.");
        } else {
            req.setAttribute("demandes", demandes);
        }

        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);

    }

}









//
//
//
//package org.example.credit.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//import java.util.List;
//import org.example.credit.model.CreditDemande;
//import org.example.credit.service.CreditDemandeService;
//import org.example.credit.service.impl.CreditDemandeServiceImpl;
//
//@WebServlet("/list")
//public class ListeDemandeServlet extends HttpServlet {
//    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();
//
//    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String dateParam = req.getParameter("date");
////        String etatParam = req.getParameter("etat");
////
//////        System.out.println(dateParam);
//////        System.out.println(etatParam);
////
////        List<CreditDemande> demandes;
////
////        // Si des filtres sont appliqués
////        if (dateParam != null || etatParam != null) {
////            LocalDate date = (dateParam != null && !dateParam.isEmpty()) ? LocalDate.parse(dateParam) : null;
////            demandes = creditDemandeService.filterDemandes(date, etatParam);
////        } else {
////            // Sinon, récupérer toutes les demandes
////            demandes = creditDemandeService.getAllDemandes();
////        }
////
////        System.out.println("### doGet Method Called ###");
////        System.out.println("Nombre de demandes récupérées: " + demandes.size());
////
////        if (demandes.isEmpty()) {
////            req.setAttribute("message", "Aucune demande de crédit trouvée.");
////        } else {
////            req.setAttribute("demandes", demandes);
////        }
////
////        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
////    }
//
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
//}
