package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tournoi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTournoi;
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @OneToMany(mappedBy="tournoi",fetch=FetchType.LAZY)
    private List<Journee> journees;

    public Long getIdTournoi() {
        return idTournoi;
    }

    public void setIdTournoi(Long idTournoi) {
        this.idTournoi = idTournoi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }
}
