package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Carton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface CartonRepository extends JpaRepository<Carton,Long> {
    @Query(value = "SELECT * FROM Carton WHERE joueur_id_joueur = :id", nativeQuery = true)
    List<Carton> findByJoueur(@Param("id") Long id);
    List<Carton> findAll();
    @Query("SELECT c FROM Carton c WHERE c.joueur.idJoueur = :joueurId")
    Carton findByJoueurId(@Param("joueurId") Long joueurId);
}
