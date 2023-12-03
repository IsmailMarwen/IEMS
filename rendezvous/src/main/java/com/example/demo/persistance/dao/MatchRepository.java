package com.example.demo.persistance.dao;
import com.example.demo.persistance.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface MatchRepository extends JpaRepository<Match,Long> {
}
