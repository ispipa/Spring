package com.example.biblioteca.interfaces;

import java.util.Date;
import java.util.List;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.entities.Tarjeta;

public interface ITarjetaService {

	public List<Tarjeta> getAll() throws ErrorException;
	
	public List<Tarjeta> getAllMatch(Tarjeta tarjeta) throws ErrorException;
	
	public Tarjeta getById(Long id) throws ErrorException;
	
	public Tarjeta save(Tarjeta tarjeta);
	
	public Tarjeta update(Tarjeta tarjeta) throws ErrorException;
	
	public void deleteById(Long id) throws ErrorException;
	
	public void castigarTarjeta(Tarjeta tarjeta) throws ErrorException;

	public boolean comprobarTarjeta(Tarjeta tarjeta) throws ErrorException;
}
