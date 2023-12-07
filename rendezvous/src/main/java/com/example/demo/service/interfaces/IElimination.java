
package com.example.demo.service.interfaces;
import java.util.List;

import com.example.demo.persistance.entities.Elimination;


public interface IElimination {

    List<Elimination> getEliminationByJoueur(Long id);
}
