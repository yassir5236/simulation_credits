package org.example.credit.repository.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.credit.repository.GenericRepository;
import org.example.credit.utils.JpaUtil;

import java.util.List;
import java.util.Optional;

public abstract class GenericDaoImpl<T, ID> implements GenericRepository<T, ID> {


    private final Class<T> entityClass;
    private final String entityName;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        entityName = entityClass.getSimpleName();
    }

//        @Override
//        public Optional<T> findById(ID id) {
//            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//            return em.find(entityClass, id);
//        }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        T entity = em.find(entityClass, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("SELECT d FROM " + entityName + " d", entityClass).getResultList();
    }

    @Override
    public void save(T entity) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T entity) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            System.out.println(entity);
            transaction.begin();
            em.merge(entity);
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

}