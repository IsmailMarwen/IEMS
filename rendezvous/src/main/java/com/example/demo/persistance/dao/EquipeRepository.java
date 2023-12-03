package com.example.demo.persistance.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.persistance.entities.Equipe;
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    Equipe findByNom(String nom);
    @Query(value = "select count(*) from equipe",nativeQuery = true)
    int getNbEquipe();
    @Query(value = "select * from equipe where id_equipe= :id",nativeQuery = true)
    Equipe getEquipeById(@Param("id") Long id);
}
