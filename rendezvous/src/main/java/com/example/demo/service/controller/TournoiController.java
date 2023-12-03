package com.example.demo.service.controller;
import com.example.demo.persistance.dao.CreateTournoiRequest;
import com.example.demo.persistance.entities.Tournoi;
import com.example.demo.service.interfaces.ITournoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}

