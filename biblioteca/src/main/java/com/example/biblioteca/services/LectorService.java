package com.example.biblioteca.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;
import com.example.biblioteca.entities.Lector;
import com.example.biblioteca.entities.Prestamo;
import com.example.biblioteca.interfaces.ILectorService;
import com.example.biblioteca.repositories.LectorRespository;
import com.example.biblioteca.repositories.PrestamoRepository;

@Service
public class LectorService implements ILectorService{

	@Autowired
	private LectorRespository lectorRepositorio;
	
	//Puedes llamar a los demas repositorios o a los propios servicios, lo que tu mas prefierass
	@Autowired
	private PrestamoRepository prestamoRepositorio;

	@Override
	public List<Lector> getAll() throws ErrorException {
		List<Lector> lectores = lectorRepositorio.findAll();
		if(lectores.isEmpty())
			throw new ErrorException(Errores.VACIO, HttpStatus.OK);
		return lectores;
	}

	@Override
	public Lector getById(Long id) throws ErrorException {
		return lectorRepositorio.findById(id).orElseThrow(() -> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
	}

	@Override
	public Lector save(Lector lector) {
		return lectorRepositorio.save(lector);
	}

	@Override
	public Lector update(Lector lector) throws ErrorException {
		this.getById(lector.getIdLector());
		return lector;
	}

	@Override
	public void deleteById(Long id) throws ErrorException {
		this.getById(id);
		lectorRepositorio.deleteById(id);
	}

	@Override
	public List<Lector> getByMatcher(Lector lector) throws ErrorException {
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues();
		
		return lectorRepositorio.findAll(Example.of(lector, matcher));
	}

}
