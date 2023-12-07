package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.EliminationRepository;

import com.example.demo.persistance.entities.*;
import com.example.demo.service.interfaces.IElimination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EliminationService implements IElimination {
    @Autowired
    private EliminationRepository eliminationRepository;



    @Override
    public List<Elimination> getEliminationByJoueur(Long id) {
        return eliminationRepository.findByJoueur(id);
    }
}
