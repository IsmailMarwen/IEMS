package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import com.example.demo.persistance.entities.Equipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    Equipe findByNom(String nom);
    @Query(value = "select count(*) from equipe",nativeQuery = true)
    int getNbEquipe();
    @Query(value = "select * from equipe where id_equipe= :id",nativeQuery = true)
    Equipe getEquipeById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Equipe  SET nom = :nom WHERE id = :id")
    @Transactional
    int updateNomById(Long id, String nom);
    List<Equipe> findAll();
    @Query(value = "SELECT * FROM Equipe WHERE tournoi_id_tournoi = :id", nativeQuery = true)
    List<Equipe> findByTournoi(@Param("id") Long id);
}