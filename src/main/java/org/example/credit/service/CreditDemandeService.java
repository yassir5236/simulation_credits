package org.example.credit.service;



import org.example.credit.model.CreditDemande;

import java.time.LocalDate;
import java.util.List;

public interface CreditDemandeService {
    CreditDemande getDemandeById(Long id);
    List<CreditDemande> getAllDemandes();
    void createDemande(CreditDemande demande);
    void updateDemande(CreditDemande demande);
    void deleteDemande(Long id);
    List<CreditDemande> searchByEtat(String etat);

//    public List<CreditDemande> filterDemandes(LocalDate date, String etat);
}

