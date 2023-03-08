package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.entities.Lector;

@Repository
public interface LectorRespository extends JpaRepository<Lector, Long>{

}
