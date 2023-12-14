package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Elimination;
import com.example.demo.service.interfaces.IElimination;


import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/elimination")
public class EliminationController {
    @Autowired
    IElimination eliminationService;


    @GetMapping("/eliminationbyJoueur/{id}")
    public List<Elimination> getEliminationByJoueur(@PathVariable Long id) {
        List<Elimination> eliminations = eliminationService.getEliminationByJoueur(id);
        return eliminations ;
    }
    @GetMapping("/nb/{id}")
    public int getnbElim(@PathVariable Long id) {
        return  eliminationService.getNbElimin(id);
    }
}
