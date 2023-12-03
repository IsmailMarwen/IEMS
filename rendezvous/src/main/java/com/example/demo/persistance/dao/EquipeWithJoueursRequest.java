package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Equipe;

import java.util.List;

public class EquipeWithJoueursRequest {
    private Equipe equipe;
    private List<Long> joueurIds;

    // getters and setters

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<Long> getJoueurIds() {
        return joueurIds;
    }

    public void setJoueurIds(List<Long> joueurIds) {
        this.joueurIds = joueurIds;
    }
}
