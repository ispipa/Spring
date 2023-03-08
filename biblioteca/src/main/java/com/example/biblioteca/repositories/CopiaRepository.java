package com.example.biblioteca.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.entities.Copia;

@Repository
public interface CopiaRepository extends JpaRepository<Copia, Long>{
	
	List<Copia> findByfdAdquisicionBefore(Date tiempo);
	
	List<Copia> findByfdAdquisicionAfter(Date tiempo);
	
	List<Copia> findByfdAdquisicionBetween(Date tiempo, Date tiempo2);
}
