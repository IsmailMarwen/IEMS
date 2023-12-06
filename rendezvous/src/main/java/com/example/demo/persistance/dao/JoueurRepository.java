package com.example.demo.persistance.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.persistance.entities.Joueur;
public interface JoueurRepository extends JpaRepository<Joueur,Long> {
    @Query("SELECT j.equipe.idEquipe FROM Joueur j WHERE j.idJoueur = :joueurId")
    Long findEquipeIdByJoueurId(@Param("joueurId") Long joueurId);

}
