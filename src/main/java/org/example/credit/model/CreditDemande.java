
//
//
//package org.example.credit.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//import java.time.LocalDate;
//import org.example.credit.model.Enum.Etat;  // Import de l'énumération
//
//@Entity
//@Table(name = "credit_demande")
//public class CreditDemande {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long numero;
//
//    @Column(nullable = false)
//    @NotNull(message = "La date de la demande ne peut pas être nulle.")
//    private LocalDate date;
//
////    @Enumerated(EnumType.STRING)  // Indique que l'énumération sera stockée sous forme de chaîne dans la base de données
////    @Column(nullable = false)
////    @NotNull(message = "L'état de la demande ne peut pas être nul.")
////    private Etat etat;
//
//    @Column(nullable = false)
//    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant doit être positif.")
//    private Double montant;
//
//    @Column(nullable = false)
//    @Min(value = 1, message = "La durée doit être d'au moins 1 mois.")
//    private int duree;
//
//    @Column(length = 500)
//    private String remarques;
//
//    @Column(nullable = false)
//    @DecimalMin(value = "0.0", inclusive = false, message = "Le taux d'intérêt doit être positif.")
//    private Double tauxInteret;
//
//    @Column(nullable = false)
//    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant de la mensualité doit être positif.")
//    private Double mensualite;
//
//    @Column(nullable = false)
//    @DecimalMin(value = "0.0", inclusive = false, message = "Le coût total doit être positif.")
//    private Double coutTotal;
//
//    @Column(nullable = false)
//    @NotEmpty(message = "Le nom ne peut pas être vide.")
//    private String nom;
//
//    @Column(nullable = false)
//    @NotEmpty(message = "Le prénom ne peut pas être vide.")
//    private String prenom;
//
//    @Column(nullable = false)
//    @Min(value = 18, message = "L'âge doit être d'au moins 18 ans.")
//    @Max(value = 120, message = "L'âge ne peut pas dépasser 120 ans.")
//    private int age;
//
//    @Column(nullable = false)
//    @NotEmpty(message = "La profession ne peut pas être vide.")
//    private String profession;
//
//    @Column(nullable = false)
//    @Email(message = "L'email doit être valide.")
//    private String email;
//
//    @Column(nullable = false)
//    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Le numéro de téléphone doit être valide.")
//    private String telephone;
//
//    // Constructeur par défaut
//    public CreditDemande() {}
//
//    // Getters et Setters
//
//    public Long getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Long numero) {
//        this.numero = numero;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
////    public Etat getEtat() {
////        return etat;
////    }
////
////    public void setEtat(Etat etat) {
////        this.etat = etat;
////    }
//
//    public Double getMontant() {
//        return montant;
//    }
//
//    public void setMontant(Double montant) {
//        this.montant = montant;
//    }
//
//    public int getDuree() {
//        return duree;
//    }
//
//    public void setDuree(int duree) {
//        this.duree = duree;
//    }
//
//    public String getRemarques() {
//        return remarques;
//    }
//
//    public void setRemarques(String remarques) {
//        this.remarques = remarques;
//    }
//
//    public Double getTauxInteret() {
//        return tauxInteret;
//    }
//
//    public void setTauxInteret(Double tauxInteret) {
//        this.tauxInteret = tauxInteret;
//    }
//
//    public Double getMensualite() {
//        return mensualite;
//    }
//
//    public void setMensualite(Double mensualite) {
//        this.mensualite = mensualite;
//    }
//
//    public Double getCoutTotal() {
//        return coutTotal;
//    }
//
//    public void setCoutTotal(Double coutTotal) {
//        this.coutTotal = coutTotal;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getProfession() {
//        return profession;
//    }
//
//    public void setProfession(String profession) {
//        this.profession = profession;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public void calculerCoutTotal() {
//        this.coutTotal = this.mensualite * this.duree;
//    }
//}






package org.example.credit.model;
import org.example.credit.model.Enum.Etat;  // Import de l'énumération

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "credit_demande")
public class CreditDemande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;

//    @Column(nullable = true)
//    @NotNull(message = "La date de la demande ne peut pas être nulle.")
//    private LocalDate date;

    @Column(nullable = true)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant doit être positif.")
    private Double montant;

    @Column(nullable = true)
    @Min(value = 1, message = "La durée doit être d'au moins 1 mois.")
    private int duree;

//    @Column(length = 500)
//    private String remarques;

//    @Column(nullable = true)
//    @DecimalMin(value = "0.0", inclusive = false, message = "Le taux d'intérêt doit être positif.")
//    private Double tauxInteret;

    @Column(nullable = true)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant de la mensualité doit être positif.")
    private Double mensualite;

    @Column(nullable = true)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le coût total doit être positif.")
    private Double coutTotal;

    @Column(nullable = true)
    @NotEmpty(message = "Le nom ne peut pas être vide.")
    private String nom;

    @Column(nullable = true)
    @NotEmpty(message = "Le prénom ne peut pas être vide.")
    private String prenom;

//    @Column(nullable = true)
//    @Min(value = 18, message = "L'âge doit être d'au moins 18 ans.")
//    @Max(value = 120, message = "L'âge ne peut pas dépasser 120 ans.")
//    private int age;

//    @Enumerated(EnumType.STRING)  // Indique que l'énumération sera stockée sous forme de chaîne dans la base de données
//    @Column(nullable = true)
//    @NotNull(message = "L'état de la demande ne peut pas être nul.")
//    private Etat etat;

    @Column(nullable = true)
    @NotEmpty(message = "La profession ne peut pas être vide.")
    private String profession;

    @Column(nullable = true)
    @Email(message = "L'email doit être valide.")
    private String email;

    @Column(nullable = true)
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Le numéro de téléphone doit être valide.")
    private String telephone;

    // Nouveaux champs ajoutés
    @Column(nullable = true)
    @NotEmpty(message = "La civilité ne peut pas être vide.")
    private String civilite;

    @Column(nullable = true)
    @NotEmpty(message = "Le CIN ne peut pas être vide.")
    private String cin;

    @Column(nullable = true)
    @NotNull(message = "La date de naissance ne peut pas être nulle.")
    private LocalDate dateNaissance;

    @Column(nullable = true)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le revenu doit être positif.")
    private Double revenus;

    // Constructeur par défaut
    public CreditDemande() {}


    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Double getRevenus() {
        return revenus;
    }

    public void setRevenus(Double revenus) {
        this.revenus = revenus;
    }



    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

//    public LocalDate getDate() {
//        return date;
//    }

//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

//    public Etat getEtat() {
//        return etat;
//    }
//
//    public void setEtat(Etat etat) {
//        this.etat = etat;
//    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

//    public String getRemarques() {
//        return remarques;
//    }

//    public void setRemarques(String remarques) {
//        this.remarques = remarques;
//    }

//    public Double getTauxInteret() {
//        return tauxInteret;
//    }

//    public void setTauxInteret(Double tauxInteret) {
//        this.tauxInteret = tauxInteret;
//    }

    public Double getMensualite() {
        return mensualite;
    }

    public void setMensualite(Double mensualite) {
        this.mensualite = mensualite;
    }

    public Double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(Double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

//    public int getAge() {
//        return age;
//    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void calculerCoutTotal() {
        this.coutTotal = this.mensualite * this.duree;
    }
}
