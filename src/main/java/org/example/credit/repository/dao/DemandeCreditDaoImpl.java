package org.example.credit.repository.dao;


import jakarta.persistence.TypedQuery;
import org.example.credit.model.CreditDemande;

import org.example.credit.repository.DemandeCreditRepository;
import org.example.credit.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DemandeCreditDaoImpl implements DemandeCreditRepository {

    @Override
    public CreditDemande findById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        return em.find(CreditDemande.class, id);
    }

    @Override
    public List<CreditDemande> findAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("SELECT d FROM CreditDemande d", CreditDemande.class).getResultList();
    }

    @Override
    public void save(CreditDemande demande) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(demande);
            System.out.println("im in dao");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(CreditDemande demande) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            System.out.println(demande);
            transaction.begin();
            em.merge(demande);
            System.out.println("Etat in dao");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            CreditDemande demande = em.find(CreditDemande.class, id);
            if (demande != null) {
                em.remove(demande);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }


//    @Override
//    public List<CreditDemande> findByDateAndEtat(LocalDate dateModife, String etat) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        List<CreditDemande> result = new ArrayList<>();
//
//        try {
//            // Construction de la requête JPQL pour filtrer par date de modification et état
//            String queryStr = "SELECT d.creditDemande FROM CreditDemandeEtat d WHERE 1=1";
//
//            // Ajout de la condition de filtre par date de modification si présente
//            if (dateModife != null) {
//                queryStr += " AND d.dateModife = :dateModife";
//            }
//
//            // Ajout de la condition de filtre par état si présent
//            if (etat != null && !etat.isEmpty()) {
//                queryStr += " AND d.etat.etat = :etat";
//            }
//
//            // Création de la requête avec les conditions dynamiques
//            TypedQuery<CreditDemande> query = em.createQuery(queryStr, CreditDemande.class);
//
//            // Ajout des paramètres dans la requête
//            if (dateModife != null) {
//                query.setParameter("dateModife", dateModife);
//            }
//
//            if (etat != null && !etat.isEmpty()) {
//                query.setParameter("etat", etat);
//            }
//
//            // Exécution de la requête et récupération des résultats
//            result = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();  // Gestion des exceptions
//        } finally {
//            em.close();  // Fermeture de l'EntityManager
//        }
//
//        return result;  // Retourne la liste filtrée
//    }


    @Override
    public List<CreditDemande> rechercherDemandeCredit(LocalDate dateModife, String etat) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        // Construction de la requête JPQL avec jointures et filtres conditionnels
        String jpql = "SELECT cd FROM CreditDemande cd " +
                "LEFT JOIN cd.creditDemandeEtats cde " +
                "LEFT JOIN cde.etat e " +
                "WHERE 1=1 "; // Cette condition 1=1 est utilisée pour faciliter l'ajout dynamique de filtres

        if (dateModife != null) {
            jpql += "AND cde.dateModife = :dateModife ";
        }

        if (etat != null && !etat.isEmpty()) {
            jpql += "AND e.etat = :etat ";
        }

        TypedQuery<CreditDemande> query = em.createQuery(jpql, CreditDemande.class);

        // Définir les paramètres de la requête si les filtres sont appliqués
        if (dateModife != null) {
            query.setParameter("dateModife", dateModife);
        }

        if (etat != null && !etat.isEmpty()) {
            query.setParameter("etat", etat);
        }

        // Renvoyer la liste des résultats
        return query.getResultList();
    }
}
