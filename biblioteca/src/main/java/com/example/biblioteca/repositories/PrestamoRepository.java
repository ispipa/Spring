package com.example.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.entities.Lector;
import com.example.biblioteca.entities.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{
	
	List<Prestamo> findByLector(Lector lector);
}
