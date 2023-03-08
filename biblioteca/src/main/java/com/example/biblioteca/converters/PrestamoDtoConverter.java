package com.example.biblioteca.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.dtos.PrestamoDto;
import com.example.biblioteca.entities.Prestamo;

@Component
public class PrestamoDtoConverter {

	@Autowired
	private CopiaDtoConverter copiaConverter;
	
	@Autowired
	private LectorDtoConverter lectorConverter;
	
	public PrestamoDto convert(Prestamo prestamo) {
		return new PrestamoDto(prestamo.getIdCopia(), copiaConverter.convert(prestamo.getCopia()), 
				lectorConverter.convert(prestamo.getLector()), prestamo.getFdPrestacion(), prestamo.getFdDevolver(), prestamo.getActive());
	}
	
	public Prestamo reconvert(PrestamoDto prestamoDto) {
		return new Prestamo(prestamoDto.getIdCopia(), copiaConverter.reconvert(prestamoDto.getCopia()), 
				lectorConverter.reconvert(prestamoDto.getLector()), prestamoDto.getFdPrestacion(), prestamoDto.getFdDevolver(), prestamoDto.getActive());
	}
	
	public List<PrestamoDto> convert(List<Prestamo> prestamos){
		return prestamos.stream().map(prestamo -> convert(prestamo)).collect(Collectors.toList());
	}
	
	public List<Prestamo> reconvert(List<PrestamoDto> prestamosDto){
		return prestamosDto.stream().map(prestamoDto -> reconvert(prestamoDto)).collect(Collectors.toList());
	}
}
