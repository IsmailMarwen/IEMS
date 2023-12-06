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
public class Joueur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJoueur;
    private String nom;
    private String image;
    @OneToMany(mappedBy="joueur",fetch=FetchType.LAZY)
    private List<SauvCarton> sauvCartonList;
    @OneToMany(mappedBy="joueur",fetch=FetchType.LAZY)
    private List<Carton> cartons;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Equipe equipe;
    @OneToMany(mappedBy="joueur",fetch=FetchType.LAZY)
    private List<Butteur> butteurs;
    public Long getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(Long idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<SauvCarton> getSauvCartonList() {
        return sauvCartonList;
    }

    public void setSauvCartonList(List<SauvCarton> sauvCartonList) {
        this.sauvCartonList = sauvCartonList;
    }

    public List<Carton> getCartons() {
        return cartons;
    }

    public void setCartons(List<Carton> cartons) {
        this.cartons = cartons;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<Butteur> getButteurs() {
        return butteurs;
    }

    public void setButteurs(List<Butteur> butteurs) {
        this.butteurs = butteurs;
    }
}
