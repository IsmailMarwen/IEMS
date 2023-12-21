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
@Transactional
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
        tournoi.setDateDebut(request.getDateDebut());
        tournoi.setDateFin(request.getDateFin());
        tournoi = tournoiRepository.save(tournoi);
        List<Equipe> equipes = equipeRepository.findAllById(request.getEquipeIds());
        for (Equipe equipe : equipes) {
            equipe.setTournoi(tournoi);
            equipeRepository.save(equipe);
        }
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

            List<Journee> journees = journeeRepository.findByTournoi(tournoi);
            journeeRepository.deleteAll(journees);
            equipeRepository.updateTournoiToNull(tournoi);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean updateTournoi(Tournoi tournoi) {
        tournoiRepository.saveAndFlush(tournoi);
        return true;
    }
    @Override
    public List<Tournoi> getAllTournoi() {
        return tournoiRepository.findAll();
    }

    @Override
    public Tournoi getTournoiById(Long idTournoi) {
        Optional<Tournoi> optionalTournoi = tournoiRepository.findById(idTournoi);
        return optionalTournoi.orElse(null);
    }

}
