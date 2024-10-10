//package org.example.credit.service.impl;
//
//import org.example.credit.repository.DemandeCreditRepository;
//import org.example.credit.service.CreditDemandeService;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public abstract class GenericCreditDemandeService<T> implements CreditDemandeService<T> {
//
//    protected abstract DemandeCreditRepository<T, Long> getRepository();  // Parameterized
//
//    @Override
//    public T getDemandeById(Long id) {
//        return getRepository().findById(id);
//    }
//
//    @Override
//    public List<T> getAllDemandes() {
//        return getRepository().findAll();
//    }
//
//    @Override
//    public void createDemande(T demande) {
//        getRepository().save(demande);
//    }
//
//    @Override
//    public void updateDemande(T demande) {
//        getRepository().update(demande);
//    }
//
//    @Override
//    public void deleteDemande(Long id) {
//        getRepository().delete(id);
//    }
//
//    @Override
//    public List<T> filterDemandes(LocalDate date, String etat) {
//        return getRepository().rechercherDemandeCredit(date, etat);
//    }
//}
