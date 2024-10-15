package org.example.credit.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.credit.model.CreditDemande;
import org.example.credit.model.CreditDemandeEtat;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/detailDemande")
public class DetailDemandeServlet extends HttpServlet {
    @Inject
    private  CreditDemandeService creditDemandeService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String demandeIdString = request.getParameter("demandeId");

        Long demandeId = Long.parseLong(demandeIdString);
        CreditDemande demande = creditDemandeService.getDemandeById(demandeId);


        List<CreditDemandeEtat> etats = new ArrayList<>(demande.getCreditDemandeEtats());
        etats.sort(Comparator.comparing(CreditDemandeEtat::getDateModife));

        request.setAttribute("demande", demande);
        request.setAttribute("etatsTries", etats);
        request.getRequestDispatcher("detailDemande.jsp").forward(request, response);
    }
}

