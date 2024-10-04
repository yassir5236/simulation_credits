package org.example.credit.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.credit.model.CreditDemande;
import org.example.credit.model.Enum.Etat;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.impl.CreditDemandeServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/submitForm")
public class SubmitFormServlet extends HttpServlet {

    private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Récupération des données de la session
        String project = (String) session.getAttribute("project");
        String profession = (String) session.getAttribute("profession");
        String montantStr = (String) session.getAttribute("montant");
        String dureeStr = (String) session.getAttribute("duree");
        String email = (String) session.getAttribute("email");
        String telephone = (String) session.getAttribute("telephone");

        // Récupération des paramètres du dernier formulaire
        String civilite = request.getParameter("civilite");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String cin = request.getParameter("cin");
        String dateNaissanceStr = request.getParameter("date_naissance");
        String revenusStr = request.getParameter("revenus");




        // Validation des champs
        if (montantStr == null || dureeStr == null || revenusStr == null || nom == null || prenom == null || dateNaissanceStr == null) {
            request.setAttribute("error", "Tous les champs doivent être remplis.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }

        // Conversion des paramètres en types appropriés
        double montant = Double.parseDouble(montantStr);
        int duree = Integer.parseInt(dureeStr);
        double revenus = Double.parseDouble(revenusStr);

        // Vérifier que l'utilisateur a au moins 18 ans
        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (LocalDate.now().getYear() - dateNaissance.getYear() < 18) {
            request.setAttribute("error", "L'utilisateur doit avoir au moins 18 ans.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }

        double coutTotal =200;
        double mensualite=12;


        //delete age
        //calculer cout total


        CreditDemande demande = new CreditDemande();
        demande.setMontant(montant);
        demande.setDuree(duree);
        demande.setNom(nom);
        demande.setPrenom(prenom);
        demande.setEmail(email);
        demande.setTelephone(telephone);
        demande.setCivilite(civilite);
        demande.setCin(cin);
//        demande.setEtat(Etat.ACCEPTER);
//        demande.setDate(LocalDate.now()); // Ajout de la date de la demande
        demande.setDateNaissance(dateNaissance);
        demande.setRevenus(revenus);
        demande.setProfession(profession);
        demande.setCoutTotal(coutTotal);
        demande.setMensualite(mensualite);



        System.out.println("### Données prêtes pour l'insertion dans la base de données ###");
        System.out.println("Montant : " + montant);
        System.out.println("Durée : " + duree);
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Email : " + email);
        System.out.println("Téléphone : " + telephone);
        System.out.println("Civilité : " + civilite);
        System.out.println("CIN : " + cin);
        System.out.println("Date de naissance : " + dateNaissance);
        System.out.println("Revenus : " + revenus);
        System.out.println("Profession : " + profession);
        System.out.println("Coût total : " + coutTotal);
        System.out.println("Mensualité : " + mensualite);
//        System.out.println("Etat : " + Etat.ACCEPTER);
        // Appeler le service pour créer la demande
        creditDemandeService.createDemande(demande);
        System.out.println("done3");

        // Redirection après soumission
        response.sendRedirect("listeDemande.jsp");
//        response.sendRedirect("success.jsp");


    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CreditDemande> demandes = creditDemandeService.getAllDemandes();
        System.out.println("### doGet Method Called ###");

        // Vérification si la liste est vide
        if (demandes.isEmpty()) {
            req.setAttribute("message", "Aucune demande de crédit trouvée.");
        } else {
            req.setAttribute("demandes", demandes);
        }

        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
    }

}
