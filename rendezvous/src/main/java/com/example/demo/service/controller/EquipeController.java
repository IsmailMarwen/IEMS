package com.example.demo.service.controller;
import com.example.demo.persistance.dao.EquipeWithJoueursRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Equipe;
import com.example.demo.service.interfaces.IEquipe;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipe")
public class EquipeController {
    @Autowired
    IEquipe equipeService;

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Equipe save(@RequestBody Equipe equipe) {
        System.out.println("*******save ***********");
        Equipe e=equipeService.saveEquipe(equipe);
        return e ;
    }
    @PostMapping("/saveWithJoueurs")
    Equipe saveEquipeWithJoueurs(@RequestBody EquipeWithJoueursRequest request) {
        return equipeService.saveEquipeWithJoueurs(request.getEquipe(), request.getJoueurIds());
    }


    @GetMapping("/{id}")
    Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipe(id);
    }

    @GetMapping("/nombre")
    int getnbEquipe() {
        return equipeService.getNbEquipe();
    }

    @GetMapping("/equipeByName/{name}")
    Equipe getEquipeByName(@PathVariable String name) {
        return equipeService.findEquipeByName(name);
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
        System.out.println("*******deleted***********");
        return true;
    }
    //update
    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateEquipeNom(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String nom = requestBody.get("nom");

        if (nom != null) {
            boolean miseAJourReussie = equipeService.updateEquipe(id, nom);

            if (miseAJourReussie) {
                return new ResponseEntity<>("Mise à jour réussie", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Équipe non trouvée", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Le paramètre 'nom' est manquant", HttpStatus.BAD_REQUEST);
        }
    }
    //all
    @GetMapping("/all")
    public List<Equipe> getAllEquipe() {
        return equipeService.getAllEquipe();
    }
    @GetMapping("/equipebyTournoi/{id}")
    public List<Equipe> getEquipeByTournoi(@PathVariable Long id) {
        List<Equipe> equipes = equipeService.getEquipeByTournoi(id);
        return equipes;
    }
}
