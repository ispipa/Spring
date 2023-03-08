package com.example.biblioteca.converters;

import org.springframework.stereotype.Component;

import com.example.biblioteca.dtos.LectorDto;
import com.example.biblioteca.entities.Lector;

@Component
public class LectorDtoConverter {

	public LectorDto convert(Lector lector) {
		return new LectorDto();
	}
	
	public Lector reconvert(LectorDto lector) {
		return new Lector();
	}
}
