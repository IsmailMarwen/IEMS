package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;

import java.util.List;

public interface IButteur {
    List<Butteur> getClassementButeursParTournoi(Tournoi tournoi);
    public int getNumberOfGoalsByJoueur(Joueur joueur);
}
