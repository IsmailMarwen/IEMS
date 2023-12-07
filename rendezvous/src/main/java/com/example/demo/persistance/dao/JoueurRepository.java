package com.example.demo.persistance.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.persistance.entities.Joueur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur,Long> {
    @Query("SELECT j.equipe.idEquipe FROM Joueur j WHERE j.idJoueur = :joueurId")
    Long findEquipeIdByJoueurId(@Param("joueurId") Long joueurId);
    @Modifying
    @Query("UPDATE Joueur SET equipe_id_equipe = NULL WHERE equipe_id_equipe = :equipeId")
    void updateIdeqToNull(@Param("equipeId") Long equipeId);

    @Modifying
    @Query("UPDATE Joueur  SET nom = :nom WHERE id = :id")
    @Transactional
    int updateNomById(Long id, String nom);
    @Query(value = "SELECT * FROM Joueur WHERE equipe_id_equipe = :id", nativeQuery = true)
    List<Joueur> findByEquipe(@Param("id") Long id);
}
