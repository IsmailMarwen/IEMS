package com.example.demo.service.impliments;
import java.util.Optional;
import com.example.demo.persistance.dao.*;
import com.example.demo.persistance.entities.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.time.format.DateTimeFormatter;
import com.example.demo.service.interfaces.ITournoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TournoiService implements ITournoi {

    @Autowired
    private TournoiRepository tournoiRepository;

    @Autowired
    private JourneeRepository journeeRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public Tournoi createTournoiWithJourneesAndMatches(CreateTournoiRequest request) {
        // Create and save the tournament
        Tournoi tournoi = new Tournoi();
        tournoi.setNom(request.getNom());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tournoi.setDateDebut(LocalDate.parse(request.getDateDebut(), dateFormatter));
        tournoi.setDateFin(LocalDate.parse(request.getDateFin(), dateFormatter));
        tournoi = tournoiRepository.save(tournoi);
        List<Equipe> equipes = equipeRepository.findAllById(request.getEquipeIds());
        for (int round = 0; round < equipes.size() - 1; round++) {
            Journee journee = new Journee();
            journee.setTournoi(tournoi);
            journeeRepository.save(journee);
            for (int i = 0; i < equipes.size() / 2; i++) {
                Match match = new Match();
                match.setEq1(equipes.get(i));
                match.setEq2(equipes.get(equipes.size() - 1 - i));
                match.setJournee(journee);
                match.setFinished(false);
                matchRepository.save(match);
            }

            Collections.rotate(equipes.subList(1, equipes.size()), 1);

        }

        return tournoi;
    }

    @Override
    public boolean deleteTournoi(Long id) {
        Optional<Tournoi> tournoiOptional = tournoiRepository.findById(id);
        if (tournoiOptional.isPresent()) {
            Tournoi tournoi = tournoiOptional.get();
            tournoiRepository.deleteById(id);
            journeeRepository.updateIdJourneeToNull(tournoi.getIdTournoi());
            return true;
        } else {
            return false;
        }
    }
    @Override
    @Transactional
    public boolean updateTournoi(Long id, String nom) {
        Tournoi tournoi = tournoiRepository.findById(id).orElse(null);
        if (tournoi != null) {
            tournoi.setNom(nom);
            tournoiRepository.save(tournoi);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public List<Tournoi> getAllTournoi() {
        return tournoiRepository.findAll();
    }

}
