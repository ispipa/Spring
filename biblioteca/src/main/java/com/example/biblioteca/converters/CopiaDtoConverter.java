package com.example.biblioteca.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.dtos.CopiaDto;
import com.example.biblioteca.entities.Copia;

@Component
public class CopiaDtoConverter {

	@Autowired
	private LibroDtoConverter libroConverter;
	
	public CopiaDto convert(Copia copia) {	
		return new CopiaDto(copia.getIdCopia(), libroConverter.convert(copia.getLibro()), 
				copia.getEditorial(), copia.getFdAdquisicion());
	}

	public Copia reconvert(CopiaDto copiaDto) {	
		return new Copia(copiaDto.getIdCopia(), libroConverter.reconvert(copiaDto.getLibro()), 
				null, copiaDto.getEditorial(), copiaDto.getFdAdquisicion());
	}
	
	public List<CopiaDto> convert(List<Copia> copias){
		return copias.stream().map(copia -> convert(copia)).collect(Collectors.toList());
	}
	
	public List<Copia> reconvert(List<CopiaDto> copiasDto){
		return copiasDto.stream().map(copiaDto -> reconvert(copiaDto)).collect(Collectors.toList());
	}
}
