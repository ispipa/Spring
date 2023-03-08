package com.example.biblioteca.interfaces;

import java.util.List;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.entities.Lector;

public interface ILectorService {

	public List<Lector> getAll() throws ErrorException;
	public Lector getById(Long id) throws ErrorException;
	public Lector save(Lector lector);
	public Lector update(Lector lector) throws ErrorException;
	public void deleteById(Long id) throws ErrorException;
	
	public List<Lector> getByMatcher(Lector lector) throws ErrorException;
}
