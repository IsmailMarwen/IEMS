package com.example.demo.service.impliments;


import com.example.demo.persistance.dao.*;
import com.example.demo.persistance.entities.*;

import com.example.demo.service.interfaces.IMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService implements IMatch {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private SauvCartonRepository sauvCartonRepository;

    @Autowired
    private CartonRepository cartonRepository;

    @Autowired
    private ButteurRepository butteurRepository;

    @Autowired
    private EliminationRepository eliminationRepository;

    @Autowired
    private JourneeRepository journeeRepository;

    @Autowired
    private JoueurRepository joueurRepository;
    @Transactional
    public void updateMatchAndPlayers(UpdateRequest updateRequest) {
        Match match = matchRepository.findById(updateRequest.getIdMatch())
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
        match.setScore1(updateRequest.getScore1());
        match.setScore2(updateRequest.getScore2());
        match.setFinished(true);
        updatePlayers(match, updateRequest);
        prepareEliminations(match);
        matchRepository.save(match);
    }

    private void updatePlayers(Match match, UpdateRequest updateRequest) {
        for (Butteur butteur : updateRequest.getButteurs()) {
            butteur.setMatch(match);
            butteurRepository.save(butteur);
        }
        for (Carton carton : updateRequest.getCartons()) {
            if (carton.getJoueur() != null) {
                Carton existingCarton = cartonRepository.findByJoueurId(carton.getJoueur().getIdJoueur());

                if (existingCarton != null) {
                    System.out.println("hello");
                    existingCarton.setNbJaune(existingCarton.getNbJaune()+carton.getNbJaune());
                    existingCarton.setNbRouge(existingCarton.getNbRouge()+carton.getNbRouge());
                    cartonRepository.save(existingCarton);
                } else {
                    carton.setJoueur(carton.getJoueur());
                    cartonRepository.save(carton);
                }
            } else {
                carton.setJoueur(carton.getJoueur());
                cartonRepository.save(carton);
            }
        }


        for (SauvCarton sauvCarton : updateRequest.getSauvCartons()) {
            sauvCarton.setMatch(match);
            sauvCartonRepository.save(sauvCarton);
        }
    }

    private void prepareEliminations(Match match) {
        List<Journee> nextJournees = journeeRepository.findNextJournee(match.getJournee().getIdJournee(), PageRequest.of(0, 1));
        Journee nextJournee = nextJournees.isEmpty() ? null : nextJournees.get(0);

        if (nextJournee == null) {
            return;
        }
        for (SauvCarton sauvCarton : match.getSauvcartons()) {
            int totalYellowCards = sauvCartonRepository.countTotalYellowCardsByJoueur(sauvCarton.getJoueur());
            if (totalYellowCards == 2 || sauvCarton.getNbrRouge() == 1) {
                Elimination elimination = new Elimination();
                elimination.setJoueur(sauvCarton.getJoueur());
                Long joueurId = sauvCarton.getJoueur().getIdJoueur();
                Long equipeId = joueurRepository.findEquipeIdByJoueurId(joueurId);
                Long opposingTeamId = getOpposingTeamId(match, equipeId);


                List<Match> nextMatches = matchRepository.findByJourneeIdJourneeAndEq1IdEquipeOrEq2IdEquipe(
                        nextJournee.getIdJournee(), equipeId);

                if (!nextMatches.isEmpty()) {
                    Match nextMatch = nextMatches.get(0);
                    elimination.setMatch(nextMatch);
                    eliminationRepository.save(elimination);

                    sauvCartonRepository.deleteByJoueur(sauvCarton.getJoueur());

                } else {
                    throw new EntityNotFoundException("Next match not found");
                }
            }
        }
    }

    private Long getOpposingTeamId(Match match, Long teamId) {
        if (teamId.equals(match.getEq1().getIdEquipe())) {
            return match.getEq2().getIdEquipe();
        } else if (teamId.equals(match.getEq2().getIdEquipe())) {
            return match.getEq1().getIdEquipe();
        } else {
            throw new EntityNotFoundException("Team not found in the match");
        }
    }

    @Override
    public List<Match> getMatchesByEquipe(Long idEquipe) {
        return matchRepository.findMatchesByEquipeId(idEquipe);
    }

    @Override
    public List<Joueur> getJoueursMatchs(Long idMatch) {
        Match match = matchRepository.findById(idMatch).orElse(null);

        if (match != null) {

            List<Elimination> eliminations = eliminationRepository.findByMatch(match);
            List<Joueur> joueursNonElimines = match.getEq1().getJoueurs().stream()
                    .filter(joueur -> eliminations.stream().noneMatch(elimination -> elimination.getJoueur().equals(joueur)))
                    .collect(Collectors.toList());

            joueursNonElimines.addAll(match.getEq2().getJoueurs().stream()
                    .filter(joueur -> eliminations.stream().noneMatch(elimination -> elimination.getJoueur().equals(joueur)))
                    .collect(Collectors.toList()));

            return joueursNonElimines;
        }

        return null;
    }
}

