package com.example.demo.persistance.dao;
import com.example.demo.persistance.entities.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface TournoiRepository extends JpaRepository<Tournoi,Long> {
}
