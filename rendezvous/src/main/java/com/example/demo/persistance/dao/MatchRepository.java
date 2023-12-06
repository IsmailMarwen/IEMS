package com.example.demo.persistance.dao;
import com.example.demo.persistance.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match,Long> {
    @Query("SELECT m FROM Match m WHERE m.journee.idJournee = :idJournee " +
            "AND (m.eq1.idEquipe = :equipeId OR m.eq2.idEquipe = :equipeId)")
    List<Match> findByJourneeIdJourneeAndEq1IdEquipeOrEq2IdEquipe(
            @Param("idJournee") Long idJournee,
            @Param("equipeId") Long equipeId);



}

