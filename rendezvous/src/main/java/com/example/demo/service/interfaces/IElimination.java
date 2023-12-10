
package com.example.demo.service.interfaces;
import java.util.List;

import com.example.demo.persistance.entities.Elimination;
import com.example.demo.persistance.entities.Joueur;


public interface IElimination {

    List<Elimination> getEliminationByJoueur(Long id);
    public int getNbElimin(Long idJoueur);
}
