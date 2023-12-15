package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Joueur;

import java.util.List;

public interface IJoueur  {
    Joueur saveJoueur(Joueur joueur);
    boolean updateJoueur(Joueur joueur);
    List<Joueur> getJoueurByEquipe(Long id);
    public Joueur findById(Long playerId);

    public List<Joueur> getAllJoueur();
    List<Joueur> getJoueursWithoutEquipe();
    Boolean deleteJoueur(Long idJoueur );

}
