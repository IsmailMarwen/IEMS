package com.example.demo.service.interfaces;
import java.util.List;

import com.example.demo.persistance.entities.Equipe;

public interface IEquipe {
    Equipe saveEquipe(Equipe equipe);
    Equipe saveEquipeWithJoueurs(Equipe equipe, List<Long> joueurIds);
    Equipe updateEquipe(Equipe equipe);
    boolean deleteEquipe(Long id);
    List<Equipe> getListEquipe();
    Equipe getEquipe(Long id);
    Equipe findEquipeByName(String name);
    int getNbEquipe();
    Equipe getEquipeById(Long id);
}
