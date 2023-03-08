package com.example.biblioteca.interfaces;

import java.util.List;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.entities.Prestamo;

public interface IPrestamoService {

	public List<Prestamo> getAll() throws ErrorException;
	public Prestamo getById(Long id) throws ErrorException;
	public Prestamo save(Prestamo prestamo);
	public Prestamo update(Prestamo prestamo) throws ErrorException;
	public void deleteById(Long id) throws ErrorException;
	
	public List<Prestamo> getAllByIdLector(Long idLector) throws ErrorException;
	
	public List<Prestamo> getAllMatch(Prestamo prestamo) throws ErrorException;
	
	public boolean devolverPrestamo(Long idCopia) throws ErrorException;
	
	public boolean comprobarPrestamo(Prestamo prestamo) throws ErrorException;
}
