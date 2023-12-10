package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ButteurRepository extends JpaRepository<Butteur,Long> {
    List<Butteur> findByMatch_Journee_TournoiOrderByNbButDesc(Tournoi tournoi);
    List<Butteur> findByJoueur(Joueur joueur);
}
