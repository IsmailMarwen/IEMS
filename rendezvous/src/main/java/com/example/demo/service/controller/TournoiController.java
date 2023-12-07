package com.example.demo.service.controller;
import com.example.demo.persistance.dao.CreateTournoiRequest;

import com.example.demo.persistance.entities.Tournoi;
import com.example.demo.service.interfaces.ITournoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tournoi")
public class TournoiController {

    @Autowired
    private ITournoi tournoiService;

    @PostMapping("/create")
    public ResponseEntity<Tournoi> createTournoi(@RequestBody CreateTournoiRequest request) {
        Tournoi createdTournoi = tournoiService.createTournoiWithJourneesAndMatches(request);
        return new ResponseEntity<>(createdTournoi, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        tournoiService.deleteTournoi(id);
        System.out.println("*******deleted***********");
        return true;
    }
    //update
    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateTournoiNom(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String nom = requestBody.get("nom");

        if (nom != null) {
            boolean miseAJourReussie = tournoiService.updateTournoi(id, nom);

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
    public List<Tournoi> getAllTournoi() {
        return tournoiService.getAllTournoi();
    }
}

