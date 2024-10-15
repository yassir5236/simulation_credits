package org.example.credit.service;



import org.example.credit.model.CreditDemande;
import org.example.credit.model.Etat;

import java.util.List;

public interface EtatService {
    void createEtat(Etat Etat);
    List<Etat> getAllEtat();
}


//public interface EtatService <T> {
//    void createEtat(T entity);
//}


