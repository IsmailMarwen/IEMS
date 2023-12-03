package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Equipe implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String nom;
    private String logo;
    @OneToMany(mappedBy = "eq1", fetch = FetchType.LAZY)
    private List<Match> matchesAsEq1;

    @OneToMany(mappedBy = "eq2", fetch = FetchType.LAZY)
    private List<Match> matchesAsEq2;
    @JsonIgnore
    @OneToMany(mappedBy="equipe",fetch=FetchType.LAZY)
    private List<Joueur> joueurs;

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Match> getMatchesAsEq1() {
        return matchesAsEq1;
    }

    public void setMatchesAsEq1(List<Match> matchesAsEq1) {
        this.matchesAsEq1 = matchesAsEq1;
    }

    public List<Match> getMatchesAsEq2() {
        return matchesAsEq2;
    }

    public void setMatchesAsEq2(List<Match> matchesAsEq2) {
        this.matchesAsEq2 = matchesAsEq2;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
