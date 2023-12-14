package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Joueur;
import com.example.demo.service.interfaces.IJoueur;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/joueur")
public class JoueurController {
    @Autowired
    IJoueur joueurService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Joueur save(@RequestBody Joueur joueur) {
        System.out.println("*******save ***********");
        Joueur j = joueurService.saveJoueur(joueur);
        return j;
    }

    //update
    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateJoueurNom(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String nom = requestBody.get("nom");

        if (nom != null) {
            boolean miseAJourReussie = joueurService.updateJoueur(id, nom);

            if (miseAJourReussie) {
                return new ResponseEntity<>("Mise à jour réussie", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Équipe non trouvée", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Le paramètre 'nom' est manquant", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/joueurbyEquipe/{id}")
    public List<Joueur> getJoueurByEquipe(@PathVariable Long id) {
        List<Joueur> joueurs = joueurService.getJoueurByEquipe(id);
        return joueurs;
    }
    @GetMapping("/all")
    public List<Joueur> getAllJoueurs(){
        return joueurService.getAllJoueur();
    }
    @GetMapping("/withoutEquipe")
    public List<Joueur> getJoueursWithoutEquipe() {
        return joueurService.getJoueursWithoutEquipe();
    }
}