package com.example.demo.service.interfaces;

import com.example.demo.persistance.dao.CreateTournoiRequest;

import com.example.demo.persistance.entities.Tournoi;

import java.util.List;

public interface ITournoi {
    Tournoi createTournoiWithJourneesAndMatches(CreateTournoiRequest request);
    boolean deleteTournoi(Long id);
    boolean updateTournoi(Tournoi tournoi);
    List<Tournoi> getAllTournoi();
    Tournoi getTournoiById(Long idTournoi);
}
