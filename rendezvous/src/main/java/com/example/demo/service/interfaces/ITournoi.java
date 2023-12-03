package com.example.demo.service.interfaces;

import com.example.demo.persistance.dao.CreateTournoiRequest;
import com.example.demo.persistance.entities.Tournoi;

public interface ITournoi {
    Tournoi createTournoiWithJourneesAndMatches(CreateTournoiRequest request);
}
