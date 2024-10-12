package org.example.credit.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
//    private LocalDate dateModife;
    private LocalDateTime dateModife;

    @Column(nullable = false)
    private String description;

    public CreditDemandeEtat() {

    }

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

    public LocalDateTime getDateModife() {
        return dateModife;
    }

    public void setDateModife(LocalDateTime dateModife) {
        this.dateModife = dateModife;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
