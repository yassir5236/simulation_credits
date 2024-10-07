package org.example.credit.service.impl;


import org.example.credit.model.CreditDemande;
import org.example.credit.model.Etat;
import org.example.credit.repository.DemandeCreditRepository;
import org.example.credit.repository.EtatRepository;
import org.example.credit.repository.dao.DemandeCreditDaoImpl;
import org.example.credit.repository.dao.EtatDaoImpl;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.EtatService;

import java.util.List;

public class EtatServiceImpl implements EtatService {

    private final EtatRepository etatRepository;

    public EtatServiceImpl() {
        this.etatRepository = new EtatDaoImpl();  // Injection par constructeur
    }


    @Override
    public void createEtat(Etat Etat) {
        etatRepository.save(Etat);
    }




}
