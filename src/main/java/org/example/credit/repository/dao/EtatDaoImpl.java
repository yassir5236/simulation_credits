package org.example.credit.repository.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.credit.model.CreditDemande;
import org.example.credit.model.Etat;
import org.example.credit.repository.DemandeCreditRepository;
import org.example.credit.repository.EtatRepository;
import org.example.credit.utils.JpaUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EtatDaoImpl implements EtatRepository {

//    @Override
//    public CreditDemande findById(Long id) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        return em.find(CreditDemande.class, id);
//    }
//
//    @Override
//    public List<CreditDemande> findAll() {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        return em.createQuery("SELECT d FROM CreditDemande d", CreditDemande.class).getResultList();
//    }

    @Override
    public void save(Etat etat) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(etat);
            System.out.println("im in dao");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }
//
//    @Override
//    public void update(CreditDemande demande) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            System.out.println(demande);
//            transaction.begin();
//            em.merge(demande);
//            System.out.println("Etat in dao");
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            em.close();
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            CreditDemande demande = em.find(CreditDemande.class, id);
//            if (demande != null) {
//                em.remove(demande);
//            }
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            em.close();
//        }
//    }
//
//    @Override
//    public List<CreditDemande> findByEtat(String etat) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        TypedQuery<CreditDemande> query = em.createQuery("SELECT d FROM CreditDemande d WHERE d.etat = :etat", CreditDemande.class);
//        query.setParameter("etat", etat);
//        return query.getResultList();
//    }
//
//
//    @Override
//    public List<CreditDemande> findByDateAndEtat(LocalDate date, String etat) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        List<CreditDemande> result = new ArrayList<>();
//
//        String queryStr = "SELECT d FROM CreditDemande d WHERE 1=1"; // Commence avec une condition vraie
//
//        if (date != null) {
//            queryStr += " AND d.dateDemande = :date"; // Ajoute la condition pour la date
//        }
//
//        if (etat != null && !etat.isEmpty()) {
//            queryStr += " AND d.etat = :etat"; // Ajoute la condition pour l'état
//        }
//
//        TypedQuery<CreditDemande> query = em.createQuery(queryStr, CreditDemande.class);
//
//        if (date != null) {
//            query.setParameter("date", date); // Définit le paramètre pour la date
//        }
//
//        if (etat != null && !etat.isEmpty()) {
//            query.setParameter("etat", etat); // Définit le paramètre pour l'état
//        }
//
//        result = query.getResultList(); // Exécute la requête et récupère les résultats
//        em.close(); // Ferme l'EntityManager
//        return result; // Retourne les résultats filtrés
//    }
}
