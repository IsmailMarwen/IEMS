package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Carton;

import com.example.demo.service.interfaces.ICarton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;




@RestController
@RequestMapping("/api/carton")
public class CartonController {
    @Autowired
    ICarton cartonService;
    @GetMapping("/cartonbyJoueur/{id}")
    public List<Carton> getCartonByJoueur(@PathVariable Long id) {
        List<Carton> cartons = cartonService.getCartonByJoueur(id);
        return cartons;
    }
    //all
    @GetMapping("/all")
    public List<Carton> getAllCarton() {
        return cartonService.getAllCarton();
    }
}
