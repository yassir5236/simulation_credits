//package org.example.credit.service.impl;
//
//import org.example.credit.repository.EtatRepository;
//import org.example.credit.service.EtatService;
//
//public abstract class GenericEtatServiceImpl<T> implements EtatService<T> {
//
//    protected abstract EtatRepository<T> getRepository();
//
//    @Override
//    public void createEtat(T entity) {
//        getRepository().save(entity);
//    }
//}