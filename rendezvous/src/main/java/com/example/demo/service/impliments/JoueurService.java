package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.JoueurRepository;
import com.example.demo.persistance.dao.EquipeRepository;
import com.example.demo.persistance.entities.Equipe;
import com.example.demo.persistance.entities.Joueur;

import com.example.demo.service.interfaces.IJoueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JoueurService implements IJoueur {
    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @Override
    @Transactional
    public boolean updateJoueur(Joueur joueur) {
        joueurRepository.saveAndFlush(joueur);
        return true;
    }

    @Override
    public List<Joueur> getJoueurByEquipe(Long id) {
        return joueurRepository.findByEquipe(id);
    }
    @Override
    public Joueur findById(Long playerId) {
        Optional<Joueur> joueurOptional = joueurRepository.findById(playerId);
        return joueurOptional.get();
    }

    @Override
    public List<Joueur> getAllJoueur() {
        return joueurRepository.findAll();
    }

    @Override
    public List<Joueur> getJoueursWithoutEquipe() {
        return joueurRepository.findByEquipeIsNull();
    }

    @Override
    public Boolean deleteJoueur(Long idJoueur) {
        Optional<Joueur> joueurOptional = joueurRepository.findById(idJoueur);
        if (joueurOptional.isPresent()) {
            Joueur joueur = joueurOptional.get();
            joueurRepository.deleteById(idJoueur);

            return true;
        } else {
            return false;
        }
    }


}
