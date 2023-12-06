package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Elimination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EliminationRepository extends JpaRepository<Elimination,Long> {
}
