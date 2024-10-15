package org.example.credit.controller;

import java.io.PrintWriter;
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
import org.example.credit.model.CreditDemandeEtat;
import org.example.credit.model.Etat;
import org.example.credit.service.CreditDemandeService;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.credit.service.EtatService;


@WebServlet("/submitForm")
public class SubmitFormServlet extends HttpServlet {


    @Inject
    private CreditDemandeService creditDemandeService;
    @Inject
    private CreditDemande creditDemande;

    @Inject
    private EtatService etatService;


    // private final CreditDemandeService creditDemandeService = new CreditDemandeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String project = (String) session.getAttribute("project");
        String profession = (String) session.getAttribute("profession");
        Double montant = (Double) session.getAttribute("montant");
        int duree = (int) session.getAttribute("duree");
        Double mensualiteFinal = (Double) session.getAttribute("mensualite");

        String justif = "En_attend";


        String email = (String) session.getAttribute("email");
        String telephone = (String) session.getAttribute("telephone");

        String civilite = request.getParameter("civilite");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String cin = request.getParameter("cin");
        String dateNaissanceStr = request.getParameter("date_naissance");
        String revenusStr = request.getParameter("revenus");

        double revenus = Double.parseDouble(revenusStr);


        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (LocalDate.now().getYear() - dateNaissance.getYear() < 18) {
            request.setAttribute("error", "L'utilisateur doit avoir au moins 18 ans.");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            return;
        }


        creditDemande.setProjet(project);
        creditDemande.setMontant(montant);
        creditDemande.setDuree(duree);
        creditDemande.setNom(nom);
        creditDemande.setPrenom(prenom);
        creditDemande.setEmail(email);
        creditDemande.setTelephone(telephone);
        creditDemande.setCivilite(civilite);
        creditDemande.setCin(cin);

        creditDemande.setDateNaissance(dateNaissance);
        creditDemande.setRevenus(revenus);
        creditDemande.setProfession(profession);
        creditDemande.setMensualite(mensualiteFinal);


        Etat pendingEtat = new Etat();
        pendingEtat.setEtat("En_attente");
        etatService.createEtat(pendingEtat);


        System.out.println(pendingEtat);


        CreditDemandeEtat creditDemandeEtat = new CreditDemandeEtat();
        creditDemandeEtat.setEtat(pendingEtat);
        creditDemandeEtat.setDescription(justif);
        creditDemandeEtat.setDateModife(LocalDate.now());
        creditDemandeEtat.setCreditDemande(creditDemande);
        creditDemande.getCreditDemandeEtats().add(creditDemandeEtat);

        creditDemandeService.updateDemande(creditDemande);



        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CreditDemande>> violations = validator.validate(creditDemande);


        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        } else {
            creditDemandeService.createDemande(creditDemande);

            response.sendRedirect(request.getContextPath() + "/list");
        }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CreditDemande> demandes = creditDemandeService.getAllDemandes();

        List<Etat> etats = etatService.getAllEtat();


        System.out.println("### doGet Method Called ###");

        if (demandes.isEmpty()) {
            req.setAttribute("message", "Aucune demande de crédit trouvée.");
        } else {
            req.setAttribute("demandes", demandes);
            req.getSession().setAttribute("etats", etats);
        }

        req.getRequestDispatcher("listeDemande2.jsp").forward(req, resp);
    }


}
