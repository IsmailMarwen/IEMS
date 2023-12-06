package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Carton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartonRepository extends JpaRepository<Carton,Long> {
}
