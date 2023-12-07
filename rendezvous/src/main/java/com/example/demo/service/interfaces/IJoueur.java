package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Joueur;

import java.util.List;

public interface IJoueur  {
    Joueur saveJoueur(Joueur joueur);
    boolean updateJoueur(Long id, String nom);
    List<Joueur> getJoueurByEquipe(Long id);
}
