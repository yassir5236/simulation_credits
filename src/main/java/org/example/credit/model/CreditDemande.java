package org.example.credit.model;




import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "credit_demande")
public class CreditDemande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;

    @Column(nullable = false)
    private LocalDate date;  // Date de la demande

    @Column(nullable = false)
    private String etat;  // État de la demande (e.g., 'en cours', 'approuvé', 'rejeté')

    @Column(nullable = false)
    private Double montant;  // Montant du prêt demandé

    @Column(nullable = false)
    private int duree;  // Durée du crédit en mois

    @Column(length = 500)
    private String remarques;  // Remarques éventuelles sur la demande

    // Informations financières supplémentaires pour la simulation
    @Column(nullable = false)
    private Double tauxInteret;  // Taux d'intérêt appliqué

    @Column(nullable = false)
    private Double mensualite;  // Montant de la mensualité calculée

    @Column(nullable = false)
    private Double coutTotal;  // Coût total du prêt avec intérêts

    // Informations personnelles de l'emprunteur
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String profession;

    // Coordonnées de l'emprunteur
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    // Constructeur par défaut
    public CreditDemande() {}

    // Getters et Setters
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

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

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    // Méthode utilitaire pour calculer le coût total du prêt
    public void calculerCoutTotal() {
        this.coutTotal = this.mensualite * this.duree;
    }
}

