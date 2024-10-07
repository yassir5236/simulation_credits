package org.example.credit.controller;

import jakarta.servlet.annotation.WebServlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.credit.model.CreditDemande;
import org.example.credit.model.CreditDemandeEtat;
import org.example.credit.model.Etat;
import org.example.credit.repository.dao.DemandeCreditDaoImpl;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.EtatService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;
import org.example.credit.service.impl.EtatServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/changerEtatDemande")
public class EtatDemandeServlet extends HttpServlet {
    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();
    private final EtatService etatService = new EtatServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String demandeIdString = request.getParameter("demandeId");
        String nouvelEtat = request.getParameter("nouvelEtat");
        String justif = request.getParameter("justif");
        Long idDemande = Long.parseLong(demandeIdString);

        CreditDemande demande = creditDemandeService.getDemandeById(idDemande);
        if (demande == null) {
            request.setAttribute("error", "Demande introuvable.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }

        // Créer un nouvel état et l'associer à la demande de crédit
        Etat etat = new Etat();
        etat.setEtat(nouvelEtat);

        etatService.createEtat(etat);


        // Créer un CreditDemandeEtat pour suivre l'état de la demande
        CreditDemandeEtat creditDemandeEtat = new CreditDemandeEtat();
        creditDemandeEtat.setEtat(etat);
        creditDemandeEtat.setDescription(justif);
        creditDemandeEtat.setDateModife(LocalDate.now());
        creditDemandeEtat.setCreditDemande(demande);

        // Ajouter le nouvel état à la collection d'états de la demande de crédit
        demande.getCreditDemandeEtats().add(creditDemandeEtat);

        // Mettre à jour la demande et persister les modifications
        creditDemandeService.updateDemande(demande);
        request.getSession().setAttribute("successMessage", "L'état de la demande a été modifié avec succès.");

        // Rediriger après la mise à jour
        response.sendRedirect(request.getContextPath() + "/submitForm");
    }
}

