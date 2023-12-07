package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Carton;


import java.util.List;

public interface ICarton {
    List<Carton> getCartonByJoueur(Long id);
    List<Carton> getAllCarton();
}
