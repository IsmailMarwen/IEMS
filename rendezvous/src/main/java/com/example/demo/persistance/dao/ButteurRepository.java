package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Butteur;
import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ButteurRepository extends JpaRepository<Butteur,Long> {
    List<Butteur> findByMatch_Journee_TournoiOrderByNbButDesc(Tournoi tournoi);
    List<Butteur> findByJoueur(Joueur joueur);
    @Query("SELECT b.joueur as joueur, SUM(b.nbBut) as totalButs FROM Butteur b WHERE b.match.journee.tournoi.idTournoi = :tournoiId GROUP BY b.joueur ORDER BY totalButs DESC")
    List<ClassementButeur> findClassementButeursByTournoi(@Param("tournoiId") Long tournoiId);

}
