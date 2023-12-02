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
public class SauvCarton implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSauvCarton;
    private int nbJaune;
    private int nbrRouge;
    @ManyToOne
    private Match match;
    @ManyToOne
    private Joueur joueur;

    public Long getIdSauvCarton() {
        return idSauvCarton;
    }

    public void setIdSauvCarton(Long idSauvCarton) {
        this.idSauvCarton = idSauvCarton;
    }

    public int getNbJaune() {
        return nbJaune;
    }

    public void setNbJaune(int nbJaune) {
        this.nbJaune = nbJaune;
    }

    public int getNbrRouge() {
        return nbrRouge;
    }

    public void setNbrRouge(int nbrRouge) {
        this.nbrRouge = nbrRouge;
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
