

package org.example.credit.controller;


import org.example.credit.model.CreditDemande;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demandes")
public class DemandeCreditController extends HttpServlet {

    private final CreditDemandeService creditDemandeService = new CreditDemandeService() {
        @Override
        public CreditDemande getDemandeById(Long id) {
            return null;
        }

        @Override
        public List<CreditDemande> getAllDemandes() {
            return List.of();
        }

        @Override
        public void createDemande(CreditDemande demande) {

        }

        @Override
        public void updateDemande(CreditDemande demande) {

        }

        @Override
        public void deleteDemande(Long id) {

        }

        @Override
        public List<CreditDemande> searchByEtat(String etat) {
            return List.of();
        }
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String etat = req.getParameter("etat");
        List<CreditDemande> demandes;

        if (etat != null) {
            demandes = creditDemandeService.searchByEtat(etat);
        } else {
            demandes = creditDemandeService.getAllDemandes();
        }

        req.setAttribute("demandes", demandes);
        req.getRequestDispatcher("/WEB-INF/views/demandes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les paramètres et créer une nouvelle demande
        String montant = req.getParameter("montant");
        String duree = req.getParameter("duree");
        String remarques = req.getParameter("remarques");
        // Création de la demande
        CreditDemande demande = new CreditDemande();
        demande.setMontant(Double.parseDouble(montant));
        demande.setDuree(Integer.parseInt(duree));
        demande.setRemarques(remarques);
        creditDemandeService.createDemande(demande);

        resp.sendRedirect("/demandes");
    }
}
