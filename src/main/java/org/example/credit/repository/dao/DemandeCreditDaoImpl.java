package org.example.credit.repository.dao;


import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.TypedQuery;
import org.example.credit.model.CreditDemande;

import org.example.credit.repository.DemandeCreditRepository;
import org.example.credit.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

//
//@ApplicationScoped
//public class DemandeCreditDaoImpl implements DemandeCreditRepository {
//
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
//
//    @Override
//    public void save(CreditDemande demande) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            em.persist(demande);
//            System.out.println("im in dao");
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            em.close();
//        }
//    }
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
//
//    @Override
//    public List<CreditDemande> rechercherDemandeCredit(LocalDate dateModife, String etat) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//
//        // Construction de la requête JPQL avec jointures et filtres conditionnels
//        String jpql = "SELECT cd FROM CreditDemande cd " +
//                "LEFT JOIN cd.creditDemandeEtats cde " +
//                "LEFT JOIN cde.etat e " +
//                "WHERE 1=1 "; // Cette condition 1=1 est utilisée pour faciliter l'ajout dynamique de filtres
//
//        if (dateModife != null) {
//            jpql += "AND cde.dateModife = :dateModife ";
//        }
//
//        if (etat != null && !etat.isEmpty()) {
//            jpql += "AND e.etat = :etat ";
//        }
//
//        TypedQuery<CreditDemande> query = em.createQuery(jpql, CreditDemande.class);
//
//        // Définir les paramètres de la requête si les filtres sont appliqués
//        if (dateModife != null) {
//            query.setParameter("dateModife", dateModife);
//        }
//
//        if (etat != null && !etat.isEmpty()) {
//            query.setParameter("etat", etat);
//        }
//
//        // Renvoyer la liste des résultats
//        return query.getResultList();
//    }
//}
//
//


@ApplicationScoped
public class DemandeCreditDaoImpl extends GenericDaoImpl<CreditDemande, Long> implements DemandeCreditRepository {

    public DemandeCreditDaoImpl() {
        super(CreditDemande.class);
    }


    @Override
    public List<CreditDemande> rechercherDemandeCredit(LocalDate dateModife, String etat) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        String jpql = "SELECT cd FROM CreditDemande cd " +
                "LEFT JOIN cd.creditDemandeEtats cde " +
                "LEFT JOIN cde.etat e " +
                "WHERE 1=1 ";

        if (dateModife != null) {
            jpql += "AND cde.dateModife = :dateModife ";
        }

        if (etat != null && !etat.isEmpty()) {
            jpql += "AND e.etat = :etat ";
        }

        TypedQuery<CreditDemande> query = em.createQuery(jpql, CreditDemande.class);

        if (dateModife != null) {
            query.setParameter("dateModife", dateModife);
        }

        if (etat != null && !etat.isEmpty()) {
            query.setParameter("etat", etat);
        }

        return query.getResultList();
    }
}
