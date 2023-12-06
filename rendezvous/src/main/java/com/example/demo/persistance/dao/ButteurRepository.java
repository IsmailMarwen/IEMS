package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Butteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButteurRepository extends JpaRepository<Butteur,Long> {
}
