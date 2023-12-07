package com.example.demo.persistance.dao;
import com.example.demo.persistance.entities.Journee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
public interface JourneeRepository extends JpaRepository<Journee,Long> {
    @Query("SELECT j FROM Journee j WHERE j.idJournee > :currentJourneeId ORDER BY j.idJournee ASC")
    List<Journee> findNextJournee(@Param("currentJourneeId") Long currentJourneeId, Pageable pageable);

    @Modifying
    @Query("UPDATE Journee SET tournoi_id_tournoi = NULL WHERE tournoi_id_tournoi = :tournoiId")
    void updateIdJourneeToNull(@Param("tournoiId") Long tournoiId);

}
