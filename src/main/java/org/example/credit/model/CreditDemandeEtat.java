package org.example.credit.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "etat_demande")
public class CreditDemandeEtat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "credit_demande_id")
    private CreditDemande creditDemande;

    @ManyToOne
    @JoinColumn(name = "etat_id")
    private Etat etat;

    @Column(nullable = false)
    private LocalDate dateModife;

    @Column(nullable = false)
    private String description;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditDemande getCreditDemande() {
        return creditDemande;
    }

    public void setCreditDemande(CreditDemande creditDemande) {
        this.creditDemande = creditDemande;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public LocalDate getDateModife() {
        return dateModife;
    }

    public void setDateModife(LocalDate dateModife) {
        this.dateModife = dateModife;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
