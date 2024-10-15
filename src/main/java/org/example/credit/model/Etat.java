//package org.example.credit.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "etat")
//public class Etat {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(nullable = false)
//    @NotEmpty(message = "L'Etat ne peut pas être nulle.")
//    private String etat;
//
////    @Column(nullable = false)
////    private LocalDate dateModife;
//
//
//
//    @ManyToMany(mappedBy = "etats")
//    private Set<CreditDemande> creditDemandes = new HashSet<>();
//
//    // Getters et setters pour la relation
//    public Set<CreditDemande> getCreditDemandes() {
//        return creditDemandes;
//    }
//
//    public void setCreditDemandes(Set<CreditDemande> creditDemandes) {
//        this.creditDemandes = creditDemandes;
//    }
//
//    // Autres getters et setters...
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEtat() {
//        return etat;
//    }
//
//    public void setEtat(String etat) {
//        this.etat = etat;
//    }
////    public LocalDate getDateModife() {
////        return dateModife;
////    }
//
////    public void setDateModife(LocalDate dateModife){
////        this.dateModife = dateModife;
////    }
//
//
//}





package org.example.credit.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "etat")
public class Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(nullable = false)
    @Column(unique=true, nullable=false)
    private String etat;

    @OneToMany(mappedBy = "etat", cascade = CascadeType.ALL)
    private Set<CreditDemandeEtat> creditDemandeEtats = new HashSet<>();

    public Etat() {

    }

    public Set<CreditDemandeEtat> getCreditDemandeEtats() {
        return creditDemandeEtats;
    }

    public void setCreditDemandeEtats(Set<CreditDemandeEtat> creditDemandeEtats) {
        this.creditDemandeEtats = creditDemandeEtats;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
