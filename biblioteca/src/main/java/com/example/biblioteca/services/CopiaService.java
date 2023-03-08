package com.example.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;
import com.example.biblioteca.converters.CopiaDtoConverter;
import com.example.biblioteca.dtos.CopiaDto;
import com.example.biblioteca.entities.Copia;
import com.example.biblioteca.interfaces.ICopiaService;
import com.example.biblioteca.repositories.CopiaRepository;

@Service
public class CopiaService implements ICopiaService{
	
	@Autowired
	private CopiaRepository repositorio;
	
	@Autowired
	private CopiaDtoConverter converter;

	@Override
	public List<CopiaDto> getAll() throws ErrorException {
		List<Copia> copias = repositorio.findAll();
		if(copias.isEmpty())
			throw new ErrorException(Errores.VACIO, HttpStatus.OK);
		return converter.convert(copias);
	}

	@Override
	public CopiaDto getById(Long id) throws ErrorException {
		return converter.convert(repositorio.findById(id).orElseThrow(() -> 
			new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK)));
	}

	@Override
	public Copia save(Copia copia) {
		return repositorio.save(copia);
	}

	@Override
	public Copia update(Copia copia) throws ErrorException {
		this.getById(copia.getIdCopia());
		return copia;
	}

	@Override
	public void deleteById(Long id) throws ErrorException {
		this.getById(id);
		repositorio.deleteById(id);
	}

	@Override
	public List<CopiaDto> getAllPaginacion(Copia copia,int init, int fin, String sort, String sortDirection) throws ErrorException {
		ExampleMatcher matcher = ExampleMatcher
        .matchingAll().withStringMatcher(StringMatcher.CONTAINING).withIgnorePaths("prestamo")
        .withMatcher("libro.titulo", ExampleMatcher.GenericPropertyMatchers.endsWith())
        .withIgnoreNullValues();
		
//		ExampleMatcher matcher = ExampleMatcher
//                .matchingAll().withStringMatcher(StringMatcher.CONTAINING)
//                .withIgnoreNullValues();
//
//        List<Alumno> alumnos = repositorio.findAll(Example.of(alumno, matcher));
        
		return converter.convert(repositorio.findAll(
				Example.of(copia, matcher),
				PageRequest.of(init, fin, 
						sortDirection.equalsIgnoreCase("asc")?Sort.by(sort).ascending():Sort.by(sort).descending())
				).getContent()
		);
	}

}
