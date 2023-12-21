package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Joueur;

public class ClassementDTO {
    private Joueur joueur;
    private Long totalButs;

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Long getTotalButs() {
        return totalButs;
    }

    public void setTotalButs(Long totalButs) {
        this.totalButs = totalButs;
    }

    public ClassementDTO(Joueur joueur, Long totalButs) {
        this.joueur = joueur;
        this.totalButs = totalButs;
    }
}
