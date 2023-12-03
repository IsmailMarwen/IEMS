package com.example.demo.service.controller;
import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Joueur;
import com.example.demo.service.interfaces.IJoueur;

@RestController
@RequestMapping("/api/joueur")
public class JoueurCintroller {
    @Autowired
    IJoueur joueurService;

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Joueur save(@RequestBody Joueur joueur) {
        System.out.println("*******save ***********");
        Joueur j=joueurService.saveJoueur(joueur);
        return j ;
    }
}
