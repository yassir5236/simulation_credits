package org.example.credit.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.example.credit.model.CreditDemande;
import org.example.credit.model.Etat;
import org.example.credit.repository.DemandeCreditRepository;
import org.example.credit.repository.EtatRepository;
import org.example.credit.repository.dao.DemandeCreditDaoImpl;
import org.example.credit.repository.dao.EtatDaoImpl;
import org.example.credit.service.CreditDemandeService;
import org.example.credit.service.EtatService;

import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@ApplicationScoped
public class EtatServiceImpl  implements EtatService {

    @Inject
    private  EtatRepository etatRepository;

//    public EtatServiceImpl() {
//        this.etatRepository = new EtatDaoImpl();
//    }


    @Override
    public void createEtat(Etat Etat) {
        etatRepository.save(Etat);
    }

    public List<Etat> getAllEtat() {
        return etatRepository.findAll();
    }

}


