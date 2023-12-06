package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Carton;
import com.example.demo.persistance.entities.SauvCarton;

import java.util.List;

public class UpdateRequest {
    private Long idMatch;
    private int score1;
    private int score2;
    private boolean finished;
    private List<Butteur> butteurs;
    private List<Carton> cartons;
    private List<SauvCarton> sauvCartons;

    // Ajoutez les méthodes getter appropriées

    public Long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Long idMatch) {
        this.idMatch = idMatch;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public List<Butteur> getButteurs() {
        return butteurs;
    }

    public void setButteurs(List<Butteur> butteurs) {
        this.butteurs = butteurs;
    }

    public List<Carton> getCartons() {
        return cartons;
    }

    public void setCartons(List<Carton> cartons) {
        this.cartons = cartons;
    }

    public List<SauvCarton> getSauvCartons() {
        return sauvCartons;
    }

    public void setSauvCartons(List<SauvCarton> sauvCartons) {
        this.sauvCartons = sauvCartons;
    }
}


