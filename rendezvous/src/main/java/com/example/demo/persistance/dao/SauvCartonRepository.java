package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Joueur;
import com.example.demo.persistance.entities.SauvCarton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SauvCartonRepository extends JpaRepository<SauvCarton,Long> {
    @Modifying
    @Query("DELETE FROM SauvCarton s WHERE s.joueur = :joueur")
    void deleteByJoueur(Joueur joueur);
    @Query("SELECT COALESCE(SUM(sc.nbJaune), 0) FROM SauvCarton sc WHERE sc.joueur = :joueur")
    int countTotalYellowCardsByJoueur(@Param("joueur") Joueur joueur);


}
