package com.example.demo.persistance.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Butteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idButteur;
    private int nbBut;
    @JsonIgnoreProperties("butteurs")
    @ManyToOne
    private Joueur joueur;

    @JsonIgnoreProperties("butteurs")
    @ManyToOne
    private Match match;

    public Long getIdButteur() {
        return idButteur;
    }

    public void setIdButteur(Long idButteur) {
        this.idButteur = idButteur;
    }

    public int getNbBut() {
        return nbBut;
    }

    public void setNbBut(int nbBut) {
        this.nbBut = nbBut;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Match getMatchs() {
        return match;
    }

    public void setMatch(Match matchs) {
        this.match = matchs;
    }
}
