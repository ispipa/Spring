package com.example.biblioteca.dtos;

import com.example.biblioteca.common.Area;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LibroDto {

	private Long idLibro;
	
	private String titulo;
	
	private String autor;
	
	private Area area;
	
	public LibroDto() {
		super();
	}

	public LibroDto(Long idLibro, String titulo, String autor, Area area) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.area = area;
	}

	public Long getIdLibro() {
		return idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Area getArea() {
		return area;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
}
