package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Elimination;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EliminationRepository extends JpaRepository<Elimination,Long> {

    @Query(value = "SELECT * FROM Elimination WHERE joueur_id_joueur = :id", nativeQuery = true)
    List<Elimination> findByJoueur(@Param("id") Long id);

    @Query("SELECT COUNT(e) FROM Elimination e WHERE e.joueur.idJoueur = :joueurId")
    int countEliminationsByJoueurId(@Param("joueurId") Long joueurId);

    List<Elimination> findByMatch(Match match);
    @Query(value = "SELECT * FROM Elimination where match_id_match=:idMatch",nativeQuery = true)
    List<Elimination> findByIdMatch(@Param("idMatch") Long idMatch);
}