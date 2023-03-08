package com.example.biblioteca.interfaces;

import java.util.List;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.entities.Libro;
import com.example.biblioteca.requests.LibroSearchRequest;
import com.example.biblioteca.responses.LibroSearchResponse;

public interface ILibrosService {

	public List<Libro> getAll() throws ErrorException;
	
	public Libro getById(Long id) throws ErrorException;
	
	public Libro save(Libro libro);
	
	public Libro update(Libro libro) throws ErrorException;
	
	public void deleteById(Long id) throws ErrorException;
	
	public List<LibroSearchResponse> getAllSearch(LibroSearchRequest libro) throws ErrorException;
}
