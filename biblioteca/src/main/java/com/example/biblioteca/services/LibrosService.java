package com.example.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;
import com.example.biblioteca.converters.LibroSearchResponseConverter;
import com.example.biblioteca.entities.Copia;
import com.example.biblioteca.entities.Libro;
import com.example.biblioteca.interfaces.ILibrosService;
import com.example.biblioteca.repositories.LibroRepository;
import com.example.biblioteca.requests.LibroSearchRequest;
import com.example.biblioteca.responses.LibroSearchResponse;

@Service
public class LibrosService implements ILibrosService{

	@Autowired
	private LibroRepository repositorio;
	
	@Autowired
	private LibroSearchResponseConverter converterLSR;

	@Override
	public List<Libro> getAll() throws ErrorException {
		List<Libro> libros = repositorio.findAll();
		if(libros.isEmpty())
			throw new ErrorException(Errores.VACIO, HttpStatus.OK);
		return libros;
	}

	@Override
	public Libro getById(Long id) throws ErrorException {
		return repositorio.findById(id).orElseThrow(() -> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
	}

	@Override
	public Libro save(Libro libro) {
		return repositorio.save(libro);
	}

	@Override
	public Libro update(Libro libro) throws ErrorException {
		this.getById(libro.getIdLibro());
		return libro;
	}

	@Override
	public void deleteById(Long id) throws ErrorException {
		this.getById(id);
		repositorio.deleteById(id);
	}
	
	@Override
	public List<LibroSearchResponse> getAllSearch(LibroSearchRequest libro) throws ErrorException {
		ExampleMatcher matcher = ExampleMatcher
                .matchingAll().withStringMatcher(StringMatcher.CONTAINING)
                .withIgnoreNullValues();
		
        List<Libro> libros = repositorio.findAll(Example.of(libro.convertToEntity(), matcher));
        
        libros.stream().forEach(
        		lib -> lib.getCopias().removeIf(
        				copia -> (copia.getPrestamo() != null && copia.getPrestamo().getActive()==true)
        		)
        );

        return converterLSR.convert(libros);
        
        
	}
}
