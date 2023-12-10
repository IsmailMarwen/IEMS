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
public class Elimination implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElimination;
    @JsonIgnore
    @ManyToOne
    private Match match;
    @JsonIgnore
    @OneToOne
    private Joueur joueur;

    public Long getIdElimination() {
        return idElimination;
    }

    public void setIdElimination(Long idElimination) {
        this.idElimination = idElimination;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
