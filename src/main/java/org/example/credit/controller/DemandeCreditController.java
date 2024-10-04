//
//
//package org.example.credit.controller;
//
//
//import org.example.credit.model.CreditDemande;
//import org.example.credit.model.Enum.Etat;
//import org.example.credit.service.CreditDemandeService;
//import org.example.credit.service.impl.CreditDemandeServiceImpl;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/demandes")
//public class DemandeCreditController extends HttpServlet {
//
//    private final CreditDemandeService creditDemandeService = new CreditDemandeService() {
//        @Override
//        public CreditDemande getDemandeById(Long id) {
//            return null;
//        }
//
//        @Override
//        public List<CreditDemande> getAllDemandes() {
//            return List.of();
//        }
//
//        @Override
//        public void createDemande(CreditDemande demande) {
//
//        }
//
//        @Override
//        public void updateDemande(CreditDemande demande) {
//
//        }
//
//        @Override
//        public void deleteDemande(Long id) {
//
//        }
//
//        @Override
//        public List<CreditDemande> searchByEtat(String etat) {
//            return List.of();
//        }
//    };
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<CreditDemande> demandes = creditDemandeService.getAllDemandes();
//        System.out.println("### doGet Method Called ###");
//
//        // Vérification si la liste est vide
//        if (demandes.isEmpty()) {
//            req.setAttribute("message", "Aucune demande de crédit trouvée.");
//        } else {
//            req.setAttribute("demandes", demandes);
//        }
//
//        req.getRequestDispatcher("/listDemande.jsp").forward(req, resp);
//    }
//
//
//    // @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        // Récupérer les paramètres du formulaire
////        String montantStr = req.getParameter("montant");
////        String dureeStr = req.getParameter("duree");
////        String remarques = req.getParameter("remarques");
//////        String etatParam = req.getParameter("etat"); // Directement récupérer l'état
////        String tauxInteretStr = req.getParameter("tauxInteret");
////        String mensualiteStr = req.getParameter("mensualite");
////        String coutTotalStr = req.getParameter("coutTotal");
////        String nom = req.getParameter("nom");
////        String prenom = req.getParameter("prenom");
////        String ageStr = req.getParameter("age");
////        String profession = req.getParameter("profession");
////        String email = req.getParameter("email");
////        String telephone = req.getParameter("telephone");
////
////
////        // Vérification des paramètres
////        if (montantStr == null || montantStr.trim().isEmpty() ||
////                dureeStr == null || dureeStr.trim().isEmpty() ||
////                tauxInteretStr == null || tauxInteretStr.trim().isEmpty() ||
////                mensualiteStr == null || mensualiteStr.trim().isEmpty() ||
////                coutTotalStr == null || coutTotalStr.trim().isEmpty() ||
////                ageStr == null || ageStr.trim().isEmpty()) {
////
////            // Gérer l'erreur ici (rediriger ou retourner un message d'erreur)
////            req.setAttribute("error", "Tous les champs doivent être remplis.");
////            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
////            return;
////        }
////
////        // Conversion des paramètres en types appropriés
////        double montant = Double.parseDouble(montantStr);
////        int duree = Integer.parseInt(dureeStr);
////        double tauxInteret = Double.parseDouble(tauxInteretStr);
////        double mensualite = Double.parseDouble(mensualiteStr);
////        double coutTotal = Double.parseDouble(coutTotalStr);
////        int age = Integer.parseInt(ageStr);
////
////        // Conversion de l'état en énumération
//////        Etat etat = Etat.valueOf(etatParam.toUpperCase()); // Utiliser valueOf pour convertir en Enum
////
////        // Création de la demande de crédit
////        CreditDemande demande = new CreditDemande();
////        demande.setMontant(montant);
////        demande.setDuree(duree);
////        demande.setRemarques(remarques);
//////        demande.setEtat(etat);
////        demande.setTauxInteret(tauxInteret);
////        demande.setMensualite(mensualite);
////        demande.setCoutTotal(coutTotal);
////        demande.setNom(nom);
////        demande.setPrenom(prenom);
////        demande.setAge(age);
////        demande.setProfession(profession);
////        demande.setEmail(email);
////        demande.setTelephone(telephone);
////
////        // Appeler le service pour créer la demande
////        creditDemandeService.createDemande(demande);
////
////        // Redirection après soumission
////        resp.sendRedirect("/demandes");
////    }
//
//}
