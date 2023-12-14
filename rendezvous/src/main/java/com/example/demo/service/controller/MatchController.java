package com.example.demo.service.controller;
import com.example.demo.persistance.dao.UpdateRequest;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Match;
import com.example.demo.service.impliments.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/update")
    public ResponseEntity<String> updateMatchAndPlayers(@RequestBody UpdateRequest updateRequest) {

        matchService.updateMatchAndPlayers(updateRequest);

        return ResponseEntity.ok("Match update avec sucées");
    }
    @GetMapping("/equipe/{equipeId}")
    public ResponseEntity<List<Match>> getMatchesByEquipeId(@PathVariable Long equipeId) {
        List<Match> matches = matchService.getMatchesByEquipe(equipeId);
        return ResponseEntity.ok(matches);
    }
    @GetMapping("/joueurs/{idMatch}")
    public List<Joueur> getJoueursMatch(@PathVariable Long idMatch){
        return  matchService.getJoueursMatchs(idMatch);
    }
}

