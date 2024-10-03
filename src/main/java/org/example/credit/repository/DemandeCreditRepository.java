package org.example.credit.repository;

import org.example.credit.model.CreditDemande;
import java.util.List;

public interface DemandeCreditRepository {
    CreditDemande findById(Long id);
    List<CreditDemande> findAll();
    void save(CreditDemande demande);
    void update(CreditDemande demande);
    void delete(Long id);
    List<CreditDemande> findByEtat(String etat);  // Recherche des demandes par état
}