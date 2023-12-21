package com.example.demo.service.controller;

import com.example.demo.persistance.dao.ClassementButeur;
import com.example.demo.persistance.dao.ClassementDTO;
import com.example.demo.persistance.dao.JoueurRepository;
import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;
import com.example.demo.service.impliments.ButteurService;
import com.example.demo.service.impliments.JoueurService;
import com.example.demo.service.impliments.TournoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/butteur")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ButteurController {
    @Autowired
    private ButteurService butteurService;
    @Autowired
    private TournoiService tournoiService;
    @Autowired
    private JoueurService joueurService;
    @GetMapping("/classement/{tournoiId}")
    public List<ClassementButeur> getClassementButeursByTournoi(@PathVariable Long tournoiId) {
        return butteurService.getClassementButeursByTournoi(tournoiId);
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
