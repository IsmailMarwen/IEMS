package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.JoueurRepository;
import com.example.demo.persistance.entities.Joueur;

import com.example.demo.service.interfaces.IJoueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoueurService implements IJoueur {
    @Autowired
    private JoueurRepository joueurRepository;
    @Override
    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @Override
    @Transactional
    public boolean updateJoueur(Long id, String nom) {
        Joueur joueur = joueurRepository.findById(id).orElse(null);
        if (joueur != null) {
            joueur.setNom(nom);
            joueurRepository.save(joueur);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Joueur> getJoueurByEquipe(Long id) {
        return joueurRepository.findByEquipe(id);
    }
}
