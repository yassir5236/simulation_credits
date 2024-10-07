
package org.example.credit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credit_demande")
public class CreditDemande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;

    @Column(nullable = false)
    @NotEmpty(message = "Le projet ne peut pas etre nulle .")
    private String projet;


    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant doit être positif.")
    private Double montant;

    @Column(nullable = false)
    @Min(value = 1, message = "La durée doit être d'au moins 1 mois.")
    private int duree;


    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant de la mensualité doit être positif.")
    private Double mensualite;


    @Column(nullable = false)
    @NotEmpty(message = "Le nom ne peut pas être vide.")
    private String nom;

    @Column(nullable = false)
    @NotEmpty(message = "Le prénom ne peut pas être vide.")
    private String prenom;


    @Column(nullable = false)
    @NotEmpty(message = "La profession ne peut pas être vide.")
    private String profession;

    @Column(nullable = false)
    @Email(message = "L'email doit être valide.")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Le numéro de téléphone doit être valide.")
    private String telephone;

    @Column(nullable = false)
    @NotEmpty(message = "La civilité ne peut pas être vide.")
    private String civilite;

    @Column(nullable = false)
    @NotEmpty(message = "Le CIN ne peut pas être vide.")
    private String cin;

    @Column(nullable = false)
    @NotNull(message = "La date de naissance ne peut pas être nulle.")
    private LocalDate dateNaissance;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Le revenu doit être positif.")
    private Double revenus;

    // Relation Many-to-Many avec Etat
    @ManyToMany(cascade = CascadeType.ALL) // Ajout de CascadeType.ALL
    @JoinTable(
            name = "etat_demande",
            joinColumns = @JoinColumn(name = "credit_demande_id"),
            inverseJoinColumns = @JoinColumn(name = "etat_id")
    )
    private Set<Etat> etats = new HashSet<>();

    // Getters et setters pour la relation
    public Set<Etat> getEtats() {
        return etats;
    }

    public void setEtats(Set<Etat> etats) {
        this.etats = etats;
    }

    public CreditDemande() {
    }


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

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
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


    public Double getMensualite() {
        return mensualite;
    }

    public void setMensualite(Double mensualite) {
        this.mensualite = mensualite;
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


}
