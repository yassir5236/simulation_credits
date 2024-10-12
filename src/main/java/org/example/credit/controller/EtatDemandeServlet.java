package org.example.credit.controller;

import jakarta.inject.Inject;
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
import java.time.LocalDateTime;

@WebServlet("/changerEtatDemande")
public class EtatDemandeServlet extends HttpServlet {
    @Inject
    private CreditDemandeService creditDemandeService;
//    @Inject
//    private CreditDemandeEtat creditDemandeEtat;
    @Inject
    private EtatService etatService;
//    @Inject
//    private Etat etat;


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
        System.out.println("nouvel etat :" +nouvelEtat);

        Etat etat = new Etat();
        etat.setEtat(nouvelEtat);
        etatService.createEtat(etat);




CreditDemandeEtat creditDemandeEtat = new CreditDemandeEtat();
        creditDemandeEtat.setEtat(etat);
        creditDemandeEtat.setDescription(justif);
        creditDemandeEtat.setDateModife(LocalDateTime.now());
        creditDemandeEtat.setCreditDemande(demande);

        demande.getCreditDemandeEtats().add(creditDemandeEtat);

        creditDemandeService.updateDemande(demande);
        request.getSession().setAttribute("successMessage", "L'état de la demande a été modifié avec succès.");

//        response.sendRedirect(request.getContextPath() + "/submitForm");
        response.sendRedirect(request.getContextPath() + "/list");

    }
}

