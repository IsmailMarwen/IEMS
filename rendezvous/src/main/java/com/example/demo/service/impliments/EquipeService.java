package com.example.demo.service.impliments;

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
public class EquipeService implements IEquipe {
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private JoueurRepository joueurRepository;

    @Override
    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe saveEquipeWithJoueurs(Equipe equipe, List<Long> joueurIds) {
        Equipe savedEquipe = equipeRepository.save(equipe);
        List<Joueur> joueurs = joueurRepository.findAllById(joueurIds);
        List<Joueur> playersWithOtherTeam = joueurs.stream().filter(joueur -> joueur.getEquipe() != null).collect(Collectors.toList());
        if (!playersWithOtherTeam.isEmpty()) {
            throw new RuntimeException("One or more players are already associated with another team.");
        }
        for (Joueur joueur : joueurs) {
            joueur.setEquipe(savedEquipe);
            joueurRepository.save(joueur);
        }
        savedEquipe.setJoueurs(joueurs);
        equipeRepository.save(savedEquipe);

        return savedEquipe;
    }


    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return equipeRepository.saveAndFlush(equipe);
    }

    @Override
    public boolean deleteEquipe(Long id) {
        Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        if (equipeOptional.isPresent()) {
            Equipe equipe = equipeOptional.get();
            equipeRepository.deleteById(id);
            joueurRepository.updateIdeqToNull(equipe.getIdEquipe());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Equipe> getListEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipe(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public Equipe findEquipeByName(String name) {
        return equipeRepository.findByNom(name);
    }

    @Override
    public int getNbEquipe() {
        return equipeRepository.getNbEquipe();
    }

    @Override
    public Equipe getEquipeById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public boolean updateEquipe(Long id, String nom) {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        if (equipe != null) {
            equipe.setNom(nom);
            equipeRepository.save(equipe);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }
    @Override
    public List<Equipe> getEquipeByTournoi(Long id) {
        return equipeRepository.findByTournoi(id);
    }
}
