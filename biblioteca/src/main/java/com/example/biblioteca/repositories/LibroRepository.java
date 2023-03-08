package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.entities.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

}
