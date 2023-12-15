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
public class Carton implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarton;
    private Long nbRouge;
    private Long nbJaune;
    @ManyToOne(fetch = FetchType.EAGER)
    private Joueur joueur;

    public Long getIdCarton() {
        return idCarton;
    }

    public void setIdCarton(Long idCarton) {
        this.idCarton = idCarton;
    }

    public Long getNbRouge() {
        return nbRouge;
    }

    public void setNbRouge(Long nbRouge) {
        this.nbRouge = nbRouge;
    }

    public Long getNbJaune() {
        return nbJaune;
    }

    public void setNbJaune(Long nbJaune) {
        this.nbJaune = nbJaune;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
