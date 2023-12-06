package com.example.demo.service.controller;
import com.example.demo.persistance.dao.UpdateRequest;
import com.example.demo.service.impliments.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

