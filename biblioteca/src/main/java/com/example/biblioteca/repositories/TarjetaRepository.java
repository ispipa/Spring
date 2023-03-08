package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long>{

	@Query(value = "SELECT * FROM tarjetas WHERE tarjetas.id_lector = :idLector",nativeQuery = true)
	public Tarjeta findByIdLector(@Param("idLector") Long idLector);
}
