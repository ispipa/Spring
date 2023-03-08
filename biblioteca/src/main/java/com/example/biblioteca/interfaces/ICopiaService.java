package com.example.biblioteca.interfaces;

import java.util.List;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.dtos.CopiaDto;
import com.example.biblioteca.entities.Copia;

public interface ICopiaService {

	public List<CopiaDto> getAll() throws ErrorException;
	
	public List<CopiaDto> getAllPaginacion(Copia copia,int init, int fin, String sort, String sortDirection) throws ErrorException;
	
	public CopiaDto getById(Long id) throws ErrorException;
	
	public Copia save(Copia copia);
	
	public Copia update(Copia copia) throws ErrorException;
	
	public void deleteById(Long id) throws ErrorException;
}
