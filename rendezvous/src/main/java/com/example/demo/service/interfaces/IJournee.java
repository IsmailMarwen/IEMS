package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Journee;
import com.example.demo.persistance.entities.Match;

import java.util.List;

public interface IJournee {

    List<Journee> getAllJournee();
    List<Match> getAllMatchByJounee(Long id);
    List<Journee> getJourneeByTournoi(Long id);

}
