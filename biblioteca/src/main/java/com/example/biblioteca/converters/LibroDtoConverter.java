package com.example.biblioteca.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.biblioteca.dtos.LibroDto;
import com.example.biblioteca.entities.Libro;

@Component
public class LibroDtoConverter {

	public LibroDto convert(Libro libro) {
		return new LibroDto(libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getArea());
	}
	
	public Libro reconvert(LibroDto libroDto) {
		return new Libro(libroDto.getIdLibro(), null, libroDto.getTitulo(), libroDto.getAutor(), libroDto.getArea());
	}
	
	public List<LibroDto> convert(List<Libro> libros){
		return libros.stream().map(libro -> convert(libro)).collect(Collectors.toList());
	}
	
	public List<Libro> reconvert(List<LibroDto> librosDto){
		return librosDto.stream().map(libroDto-> reconvert(libroDto)).collect(Collectors.toList());
	}
}
