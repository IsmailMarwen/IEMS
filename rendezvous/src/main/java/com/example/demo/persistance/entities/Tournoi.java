package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String dateDebut;
    private String dateFin;
    @JsonIgnore
    @OneToMany(mappedBy="tournoi",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Journee> journees;
    @JsonIgnore
    @OneToMany(mappedBy="tournoi",fetch=FetchType.LAZY )
    private List<Equipe> equipes;

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }
}
