package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Journee;
import com.example.demo.persistance.entities.Match;
import com.example.demo.service.impliments.JourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/journee")
public class JourneeController {
    @Autowired
    private JourneeService journeeService;

    @GetMapping("/all")
    List<Journee> getAllJournee() {
        return journeeService.getAllJournee();
    }
    @GetMapping("/matchs/{id}")
    List<Match> getAllMatchsByIdJournee(@PathVariable Long id){
       return journeeService.getAllMatchByJounee(id);

    }
    @GetMapping("/tournoi/{id}")
    List<Journee> getJourneeTournoi(@PathVariable Long id){
        return  journeeService.getJourneeByTournoi(id);
    }



}
