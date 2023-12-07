package com.example.demo.service.controller;
import com.example.demo.persistance.dao.EquipeWithJoueursRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Equipe;
import com.example.demo.service.interfaces.IEquipe;

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

}
