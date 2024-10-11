package org.example.credit.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.credit.model.CreditDemande;
import org.example.credit.service.CreditDemandeService;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;



@WebServlet("/submitForm")
public class SubmitFormServlet extends HttpServlet {
    @Inject
   private  CreditDemandeService creditDemandeService;

   // private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String project = (String) session.getAttribute("project");
        String profession = (String) session.getAttribute("profession");
        String montantStr = (String) session.getAttribute("montant");
        String dureeStr = (String) session.getAttribute("duree");
        String mensualite =(String) session.getAttribute("mensualite");


        String email = (String) session.getAttribute("email");
        String telephone = (String) session.getAttribute("telephone");

        String civilite = request.getParameter("civilite");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String cin = request.getParameter("cin");
        String dateNaissanceStr = request.getParameter("date_naissance");
        String revenusStr = request.getParameter("revenus");




        double montant = Double.parseDouble(montantStr);
        int duree = Integer.parseInt(dureeStr);
        double revenus = Double.parseDouble(revenusStr);
        double mensualiteFinal = Double.parseDouble(mensualite);

        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (LocalDate.now().getYear() - dateNaissance.getYear() < 18) {
            request.setAttribute("error", "L'utilisateur doit avoir au moins 18 ans.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }


        CreditDemande demande = new CreditDemande();
        demande.setProjet(project);
        demande.setMontant(montant);
        demande.setDuree(duree);
        demande.setNom(nom);
        demande.setPrenom(prenom);
        demande.setEmail(email);
        demande.setTelephone(telephone);
        demande.setCivilite(civilite);
        demande.setCin(cin);

        demande.setDateNaissance(dateNaissance);
        demande.setRevenus(revenus);
        demande.setProfession(profession);
        demande.setMensualite(mensualiteFinal);



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
        System.out.println("Mensualité : " + mensualiteFinal);



        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CreditDemande>> violations = validator.validate(demande);


        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        } else {
            creditDemandeService.createDemande(demande);
            response.sendRedirect(request.getContextPath() + "/list");
        }



    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CreditDemande> demandes = creditDemandeService.getAllDemandes();
        System.out.println("### doGet Method Called ###");

        if (demandes.isEmpty()) {
            req.setAttribute("message", "Aucune demande de crédit trouvée.");
        } else {
            req.setAttribute("demandes", demandes);
        }

        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
    }

}
