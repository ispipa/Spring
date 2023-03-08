package com.example.biblioteca.responses;

import java.util.List;

import com.example.biblioteca.common.Area;
import com.example.biblioteca.dtos.CopiaDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LibroSearchResponse {

	private Long idLibro;
	
	private String titulo;
	
	private String autor;
	
	private Area area;
	
	@JsonProperty(value = "copias_disponibles")
	private Integer nLibros;
	
	private List<CopiaDto> copias;

	public LibroSearchResponse() {
		super();
	}

	public LibroSearchResponse(Long idLibro, String titulo, String autor, Area area, Integer nLibros,
			List<CopiaDto> copias) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.area = area;
		this.nLibros = nLibros;
		this.copias = copias;
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

	public List<CopiaDto> getCopias() {
		return copias;
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

	public void setCopias(List<CopiaDto> copias) {
		this.copias = copias;
	}

	public Integer getnLibros() {
		return nLibros;
	}

	public void setnLibros(Integer nLibros) {
		this.nLibros = nLibros;
	}
}
