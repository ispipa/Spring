package com.example.biblioteca.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.entities.Libro;
import com.example.biblioteca.responses.LibroSearchResponse;

@Component
public class LibroSearchResponseConverter {
	
	@Autowired
	private CopiaDtoConverter copiaDtoConverter;
	
	public LibroSearchResponse convert(Libro libro) {	
		return new LibroSearchResponse(libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getArea(), 
				libro.getCopias()!=null?libro.getCopias().size():null, 
				libro.getCopias()!=null?copiaDtoConverter.convert(libro.getCopias()):null);
	}
	
	public List<LibroSearchResponse> convert(List<Libro> libros){
		return libros.stream().map(libro -> convert(libro)).collect(Collectors.toList());
	}
}
