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

    public List<CreditDemande> filterDemandes(LocalDate date, String etat);
}


//public interface CreditDemandeService<T> {
//    T getDemandeById(Long id);
//    List<T> getAllDemandes();
//    void createDemande(T demande);
//    void updateDemande(T demande);
//    void deleteDemande(Long id);
//    List<T> filterDemandes(LocalDate date, String etat);
//}

