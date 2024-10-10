package org.example.credit.repository.dao;


import jakarta.enterprise.context.ApplicationScoped;
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
//
//@ApplicationScoped
//public class EtatDaoImpl implements EtatRepository {
//
//
//
//    @Override
//    public void save(Etat etat) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            em.persist(etat);
//            System.out.println("im in dao");
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            em.close();
//        }
//    }
//
//}







@ApplicationScoped
public  class  EtatDaoImpl extends GenericDaoImpl<Etat,Long> implements EtatRepository {


    public EtatDaoImpl() {
        super(Etat.class);
    }
}
