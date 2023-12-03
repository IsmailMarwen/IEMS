package com.example.demo.persistance.dao;
import java.util.List;

public class CreateTournoiRequest {
    private String nom;
    private String dateDebut;
    private String dateFin;
    private List<Long> equipeIds;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public List<Long> getEquipeIds() {
        return equipeIds;
    }

    public void setEquipeIds(List<Long> equipeIds) {
        this.equipeIds = equipeIds;
    }
    // getters and setters
}
