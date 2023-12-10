package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.ButteurRepository;
import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;
import com.example.demo.service.interfaces.IButteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ButteurService implements IButteur {
    @Autowired
    private ButteurRepository butteurRepository;
    @Override
    public List<Butteur> getClassementButeursParTournoi(Tournoi tournoi) {
        return butteurRepository.findByMatch_Journee_TournoiOrderByNbButDesc(tournoi);
    }

    @Override
    public int getNumberOfGoalsByJoueur(Joueur joueur) {
        List<Butteur> butteurs = butteurRepository.findByJoueur(joueur);
        return butteurs.stream().mapToInt(Butteur::getNbBut).sum();
    }
}
