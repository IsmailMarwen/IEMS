package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.JoueurRepository;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.service.interfaces.IJoueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JoueurService implements IJoueur {
    @Autowired
    private JoueurRepository joueurRepository;
    @Override
    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }
}
