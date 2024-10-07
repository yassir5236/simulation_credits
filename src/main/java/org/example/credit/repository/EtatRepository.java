package org.example.credit.repository;

import org.example.credit.model.CreditDemande;
import org.example.credit.model.Etat;

import java.time.LocalDate;
import java.util.List;

public interface EtatRepository {
//    CreditDemande findById(Long id);
//    List<CreditDemande> findAll();
    void save(Etat etat);
//    void update(CreditDemande demande);
//    void delete(Long id);
//    List<CreditDemande> findByEtat(String etat);
//    List<CreditDemande> findByDateAndEtat(LocalDate date, String etat) ;

}