package org.example.credit.service;



import org.example.credit.model.CreditDemande;
import java.util.List;

public interface CreditDemandeService {
    CreditDemande getDemandeById(Long id);
    List<CreditDemande> getAllDemandes();
    void createDemande(CreditDemande demande);
    void updateDemande(CreditDemande demande);
    void deleteDemande(Long id);
    List<CreditDemande> searchByEtat(String etat);
}

