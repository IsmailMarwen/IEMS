package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TournoiRepository extends JpaRepository<Tournoi,Long> {
    @Modifying
    @Query("UPDATE Tournoi  SET nom = :nom WHERE id = :id")
    @Transactional
    int updateNomById(Long id, String nom);
    List<Tournoi> findAll();

}
