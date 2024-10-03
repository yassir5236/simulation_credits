package org.example.credit.utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

            // Commencer une transaction pour vérifier la connexion
            em.getTransaction().begin();
            System.out.println("Transaction commencée avec succès !");

            // Faire une requête simple (test)
            Long count = em.createQuery("SELECT COUNT(dc) FROM CreditDemande dc", Long.class).getSingleResult();
            System.out.println("Nombre de demandes de crédit : " + count);

            em.getTransaction().commit(); // Valider la transaction
            System.out.println("Transaction validée !");

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
