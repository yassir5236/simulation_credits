package org.example.credit.controller;

import jakarta.servlet.annotation.WebServlet;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.credit.model.CreditDemande;
import org.example.credit.model.Etat;
import org.example.credit.repository.dao.DemandeCreditDaoImpl;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/changerEtatDemande")
public class EtatDemandeServlet extends HttpServlet {
    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String demandeIdString = request.getParameter("demandeId");
        String nouvelEtat = request.getParameter("nouvelEtat");
        Long idDemande = Long.parseLong(demandeIdString);

        CreditDemande demande = creditDemandeService.getDemandeById(idDemande);
        if (demande == null) {
            request.setAttribute("error", "Demande introuvable.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }

        // Créer un nouvel état
        Etat etat = new Etat();
        etat.setEtat(nouvelEtat);
        etat.setDateModife(LocalDate.now());

        // Ajouter l'état à la demande de crédit
        demande.getEtats().add(etat);

        // Mettre à jour la demande et persister l'état
        creditDemandeService.updateDemande(demande);

        // Rediriger après la mise à jour
        response.sendRedirect(request.getContextPath() + "/listeDemande2.jsp");
    }
}

