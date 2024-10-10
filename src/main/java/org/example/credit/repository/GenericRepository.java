package org.example.credit.repository;

import org.example.credit.model.CreditDemande;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID  > {
    Optional<T> findById(ID id);
    List<T> findAll();
    void save(T demande);
    void update(T demande);
    void delete(ID id);
//    List<T> rechercherDemandeCredit(LocalDate date, String etat) ;

}