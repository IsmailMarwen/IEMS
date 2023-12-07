package com.example.demo.service.impliments;
import com.example.demo.persistance.entities.Carton;

import com.example.demo.service.interfaces.ICarton;
import com.example.demo.persistance.dao.CartonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.EquipeRepository;
import com.example.demo.persistance.dao.JoueurRepository;
import com.example.demo.persistance.entities.*;
import com.example.demo.service.interfaces.IEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartonService implements ICarton {
    @Autowired
    private CartonRepository cartonRepository;
    @Override
    public List<Carton> getCartonByJoueur(Long id) {
        return cartonRepository.findByJoueur(id);
    }


    @Override
    public List<Carton> getAllCarton()
    {
        return cartonRepository.findAll();
    }
}
