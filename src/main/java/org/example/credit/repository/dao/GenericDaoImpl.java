package org.example.credit.repository.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.credit.repository.GenericRepository;
import org.example.credit.utils.JpaUtil;

import java.util.List;

public abstract class GenericDaoImpl<T, ID> implements GenericRepository<T ,ID > {

//    @Override
//    public void save(T entity) {
//        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            em.persist(entity);
//            System.out.println("im in dao");
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            em.close();
//        }
//    }
        private final Class<T> entityClass;
        private final String entityName;

        public GenericDaoImpl(Class<T> entityClass) {
            this.entityClass = entityClass;
            entityName = entityClass.getSimpleName();
        }

        @Override
        public T findById(ID id) {
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            return em.find(entityClass, id);
        }

        @Override
        public List<T> findAll() {
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            return em.createQuery("SELECT d FROM "+ entityName + " d", entityClass).getResultList();
        }

        @Override
        public void save(T demande) {
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
        public void update(T demande) {
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
        public void delete(ID id) {
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                T demande = em.find(entityClass, id);
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

//        @Override
//        public List<T> rechercherDemandeCredit(LocalDate dateModife, String etat) {
//            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//
//            // Construction de la requête JPQL avec jointures et filtres conditionnels
//            String jpql = "SELECT cd FROM CreditDemande cd " +
//                    "LEFT JOIN cd.creditDemandeEtats cde " +
//                    "LEFT JOIN cde.etat e " +
//                    "WHERE 1=1 "; // Cette condition 1=1 est utilisée pour faciliter l'ajout dynamique de filtres
//
//            if (dateModife != null) {
//                jpql += "AND cde.dateModife = :dateModife ";
//            }
//
//            if (etat != null && !etat.isEmpty()) {
//                jpql += "AND e.etat = :etat ";
//            }
//
//            TypedQuery<CreditDemande> query = em.createQuery(jpql, CreditDemande.class);
//
//            // Définir les paramètres de la requête si les filtres sont appliqués
//            if (dateModife != null) {
//                query.setParameter("dateModife", dateModife);
//            }
//
//            if (etat != null && !etat.isEmpty()) {
//                query.setParameter("etat", etat);
//            }
//
//            // Renvoyer la liste des résultats
//            return query.getResultList();
//        }
//    }
}