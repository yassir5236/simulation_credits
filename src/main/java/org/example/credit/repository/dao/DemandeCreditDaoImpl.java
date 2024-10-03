package org.example.credit.repository.dao;



import org.example.credit.model.CreditDemande;

import org.example.credit.repository.DemandeCreditRepository;
import org.example.credit.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
            transaction.begin();
            em.merge(demande);
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

    @Override
    public List<CreditDemande> findByEtat(String etat) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("SELECT d FROM CreditDemande d WHERE d.etat = :etat", CreditDemande.class)
                .setParameter("etat", etat)
                .getResultList();
    }
}
