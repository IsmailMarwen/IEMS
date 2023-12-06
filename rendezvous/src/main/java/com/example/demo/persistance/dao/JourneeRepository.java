package com.example.demo.persistance.dao;
import com.example.demo.persistance.entities.Journee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JourneeRepository extends JpaRepository<Journee,Long> {
    @Query("SELECT j FROM Journee j WHERE j.idJournee > :currentJourneeId ORDER BY j.idJournee ASC")
    List<Journee> findNextJournee(@Param("currentJourneeId") Long currentJourneeId, Pageable pageable);


}
