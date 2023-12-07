package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Elimination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EliminationRepository extends JpaRepository<Elimination,Long> {

    @Query(value = "SELECT * FROM Elimination WHERE joueur_id_joueur = :id", nativeQuery = true)
    List<Elimination> findByJoueur(@Param("id") Long id);
}