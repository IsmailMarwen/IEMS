package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Equipe;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Match;

import java.util.List;

public interface IMatch {
    List<Match> getMatchesByEquipe(Long idEquipe);
    List<Joueur> getJoueursMatchs(Long idMatch);
}
