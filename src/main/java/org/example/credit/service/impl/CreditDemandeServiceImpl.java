package org.example.credit.service.impl;


import org.example.credit.repository.dao.DemandeCreditDaoImpl;
import org.example.credit.model.CreditDemande;
import org.example.credit.repository.DemandeCreditRepository;

import org.example.credit.service.CreditDemandeService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CreditDemandeServiceImpl implements CreditDemandeService {

    private final DemandeCreditRepository demandeCreditRepository;

    public CreditDemandeServiceImpl() {
        this.demandeCreditRepository = new DemandeCreditDaoImpl();  // Injection par constructeur
    }

    @Override
    public CreditDemande getDemandeById(Long id) {
        return demandeCreditRepository.findById(id);
    }

    @Override
    public List<CreditDemande> getAllDemandes() {
        return demandeCreditRepository.findAll();
    }

    @Override
    public void createDemande(CreditDemande demande) {
        demandeCreditRepository.save(demande);
    }

    @Override
    public void updateDemande(CreditDemande demande) {
        demandeCreditRepository.update(demande);
    }

    @Override
    public void deleteDemande(Long id) {
        demandeCreditRepository.delete(id);
    }

//    @Override
//    public List<CreditDemande> searchByEtat(String etat) {
//        return demandeCreditRepository.findByEtat(etat);
//    }

    @Override
    public List<CreditDemande> filterDemandes(LocalDate date, String etat) {
        System.out.println("Filtrer avec date: " + date + " et état: " + etat);
        return demandeCreditRepository.rechercherDemandeCredit(date, etat);  // Appel à la méthode DAO
    }




}
