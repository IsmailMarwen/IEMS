package com.example.demo.service.controller;

import com.example.demo.persistance.dao.JoueurRepository;
import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;
import com.example.demo.service.impliments.ButteurService;
import com.example.demo.service.impliments.JoueurService;
import com.example.demo.service.impliments.TournoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/butteur")
public class ButteurController {
    @Autowired
    private ButteurService butteurService;
    @Autowired
    private TournoiService tournoiService;
    @Autowired
    private JoueurService joueurService;
    @GetMapping("/classement/{tournoiId}")
    public List<Butteur> getClassementButeurs(@PathVariable Long tournoiId) {
        Tournoi tournoi = tournoiService.getTournoiById(tournoiId);
        return butteurService.getClassementButeursParTournoi(tournoi);
    }
    @GetMapping("/joueur/{playerId}")
    public int getNumberOfGoalsByPlayer(@PathVariable Long playerId) {
        Joueur joueur = joueurService.findById(playerId);

        if (joueur != null) {
            return butteurService.getNumberOfGoalsByJoueur(joueur);
        } else {
            return -1;
        }
    }
}
