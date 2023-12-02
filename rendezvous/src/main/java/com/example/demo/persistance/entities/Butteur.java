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
public class Butteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idButteur;
    private int nbBut;
    @JsonIgnore
    @OneToMany(mappedBy="butteur",fetch=FetchType.LAZY)
    private List<Joueur> joueurs;

    @ManyToOne
    private Match matchs;

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

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Match getMatchs() {
        return matchs;
    }

    public void setMatchs(Match matchs) {
        this.matchs = matchs;
    }
}
