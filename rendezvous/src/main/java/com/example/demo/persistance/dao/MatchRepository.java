package com.example.demo.persistance.dao;
import com.example.demo.persistance.entities.Equipe;
import com.example.demo.persistance.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match,Long> {
    @Query("SELECT m FROM Match m WHERE m.journee.idJournee = :idJournee " +
            "AND (m.eq1.idEquipe = :equipeId OR m.eq2.idEquipe = :equipeId)")
    List<Match> findByJourneeIdJourneeAndEq1IdEquipeOrEq2IdEquipe(
            @Param("idJournee") Long idJournee,
            @Param("equipeId") Long equipeId);

    @Query("SELECT m FROM Match m WHERE m.eq1.idEquipe = :equipeId OR m.eq2.idEquipe = :equipeId")
    List<Match> findMatchesByEquipeId(@Param("equipeId") Long equipeId);
    @Transactional
    @Modifying
    @Query("DELETE FROM Match m WHERE m.eq1 = :equipe OR m.eq2 = :equipe")
    void deleteByEq1OrEq2(@Param("equipe") Equipe equipe);
    @Query("DELETE FROM Match m WHERE m.journee.tournoi.idTournoi = :tournoiId")
    void deleteByTournoi(@Param("tournoiId") Long tournoiId);
    @Modifying
    @Query("DELETE FROM Match m WHERE m.journee.tournoi.idTournoi = :tournoiId")
    void deleteMatchesByTournoi(@Param("tournoiId") Long tournoiId);




}

