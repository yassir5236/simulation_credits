//package org.example.credit.utils;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class JpaTest {
//
//    public static void main(String[] args) {
//        // Initialiser l'EntityManagerFactory
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//
//        try {
//            // Création de l'EntityManagerFactory à partir du fichier persistence.xml
//            emf = Persistence.createEntityManagerFactory("creditPU");
//            System.out.println("EntityManagerFactory créé avec succès !");
//
//            // Création de l'EntityManager
//            em = emf.createEntityManager();
//            System.out.println("EntityManager créé avec succès !");
//
//            // Commencer une transaction pour vérifier la connexion
//            em.getTransaction().begin();
//            System.out.println("Transaction commencée avec succès !");
//
//            // Faire une requête simple (test)
//            Long count = em.createQuery("SELECT COUNT(dc) FROM CreditDemande dc", Long.class).getSingleResult();
//            System.out.println("Nombre de demandes de crédit : " + count);
//
//            em.getTransaction().commit(); // Valider la transaction
//            System.out.println("Transaction validée !");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (em != null) {
//                em.getTransaction().rollback(); // Annuler la transaction en cas d'erreur
//            }
//        } finally {
//            // Fermer l'EntityManager et l'EntityManagerFactory
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
//    }
//}
//
//
//

package org.example.credit.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.credit.model.CreditDemande;
//import org.example.credit.model.Enum.Etat;

import java.time.LocalDate;

public class JpaTest {

    public static void main(String[] args) {
        // Initialiser l'EntityManagerFactory
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            // Création de l'EntityManagerFactory à partir du fichier persistence.xml
            emf = Persistence.createEntityManagerFactory("creditPU");
            System.out.println("EntityManagerFactory créé avec succès !");

            // Création de l'EntityManager
            em = emf.createEntityManager();
            System.out.println("EntityManager créé avec succès !");

            // Commencer une transaction pour insérer les données
            em.getTransaction().begin();
            System.out.println("Transaction commencée avec succès !");

            // Exemple de données statiques
            CreditDemande demande1 = new CreditDemande();
            demande1.setMontant(10000.0);
            demande1.setDuree(36);
            demande1.setMensualite(300.0);
//            demande1.setCoutTotal(10800.0);
            demande1.setNom("Dupont");
            demande1.setPrenom("Jean");
//            demande1.setEtat(Etat.EN_COURS);
            demande1.setProfession("Ingénieur");
            demande1.setEmail("jean.dupont@example.com");
            demande1.setTelephone("+33123456789");
            demande1.setCivilite("Monsieur");
            demande1.setCin("AB123456");
            demande1.setDateNaissance(LocalDate.of(1985, 5, 20));
            demande1.setRevenus(3500.0);

            CreditDemande demande2 = new CreditDemande();
            demande2.setMontant(5000.0);
            demande2.setDuree(24);
            demande2.setMensualite(225.0);
//            demande2.setCoutTotal(5400.0);
            demande2.setNom("Martin");
            demande2.setPrenom("Lucie");
//            demande2.setEtat(Etat.ACCEPTER);
            demande2.setProfession("Comptable");
            demande2.setEmail("lucie.martin@example.com");
            demande2.setTelephone("+33678901234");
            demande2.setCivilite("Madame");
            demande2.setCin("CD789012");
            demande2.setDateNaissance(LocalDate.of(1990, 10, 15));
            demande2.setRevenus(2800.0);

            // Persister les objets dans la base de données
            em.persist(demande1);
            em.persist(demande2);

            // Valider la transaction
            em.getTransaction().commit();
            System.out.println("Données insérées avec succès !");

        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.getTransaction().rollback(); // Annuler la transaction en cas d'erreur
            }
        } finally {
            // Fermer l'EntityManager et l'EntityManagerFactory
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
