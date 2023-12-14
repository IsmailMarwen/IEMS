package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.JourneeRepository;
import com.example.demo.persistance.entities.Journee;
import com.example.demo.persistance.entities.Match;
import com.example.demo.service.interfaces.IJournee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JourneeService implements IJournee {
    @Autowired
    private JourneeRepository journeeRepository;
    @Override
    public List<Journee> getAllJournee() {
        return journeeRepository.findAll();
    }

    @Override
    public List<Match> getAllMatchByJounee(Long id) {
        Journee journee = journeeRepository.findById(id).orElse(null);
        return journee != null ? journee.getMatchs() : null;
    }

    @Override
    public List<Journee> getJourneeByTournoi(Long id) {
        return journeeRepository.findByTournoi_IdTournoi(id);
    }

}
