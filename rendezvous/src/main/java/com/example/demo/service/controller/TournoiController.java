package com.example.demo.service.controller;
import com.example.demo.persistance.dao.CreateTournoiRequest;

import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;
import com.example.demo.service.interfaces.ITournoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @PutMapping("/update")
    public Tournoi updateTournoi(@RequestBody Tournoi tournoi) {
        tournoiService.updateTournoi(tournoi);
        return tournoi;
    }
    //all
    @GetMapping("/all")
    public List<Tournoi> getAllTournoi() {
        return tournoiService.getAllTournoi();
    }

}

