package com.example.demo.service.interfaces;

import com.example.demo.persistance.dao.ClassementButeur;
import com.example.demo.persistance.dao.ClassementDTO;
import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;

import java.util.List;

public interface IButteur {
    public List<ClassementButeur> getClassementButeursByTournoi(Long tournoiId);
    public int getNumberOfGoalsByJoueur(Joueur joueur);
}
