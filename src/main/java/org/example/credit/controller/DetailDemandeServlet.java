package org.example.credit.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.credit.model.CreditDemande;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;

import java.io.IOException;

@WebServlet("/detailDemande")
public class DetailDemandeServlet extends HttpServlet {
//    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();
    @Inject
    private  CreditDemandeService creditDemandeService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String demandeIdString = request.getParameter("demandeId");
        if (demandeIdString == null || demandeIdString.isEmpty()) {
            request.setAttribute("error", "Identifiant de la demande manquant.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }

        Long demandeId = Long.parseLong(demandeIdString);
        CreditDemande demande = creditDemandeService.getDemandeById(demandeId);

        if (demande == null) {
            request.setAttribute("error", "Demande introuvable.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }

        // Récupérer l'historique des états de la demande et le passer à la JSP
        request.setAttribute("demande", demande);
        request.getRequestDispatcher("detailDemande.jsp").forward(request, response);
    }
}

