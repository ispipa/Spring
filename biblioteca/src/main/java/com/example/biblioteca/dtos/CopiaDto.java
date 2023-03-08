package com.example.biblioteca.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CopiaDto {

	@JsonProperty("id_copia")
	private Long idCopia;
	
	@JsonProperty("libro")
	private LibroDto libro;
	
	@JsonProperty("editorial")
	private String editorial;

	@JsonProperty("Fecha_de_adquisicion")
	private Date fdAdquisicion;

	public CopiaDto() {
		super();
	}

	public CopiaDto(Long idCopia, LibroDto libro, String editorial, Date fdAdquisicion) {
		super();
		this.idCopia = idCopia;
		this.libro = libro;
		this.editorial = editorial;
		this.fdAdquisicion = fdAdquisicion;
	}

	public Long getIdCopia() {
		return idCopia;
	}

	public LibroDto getLibro() {
		return libro;
	}

	public String getEditorial() {
		return editorial;
	}

	public Date getFdAdquisicion() {
		return fdAdquisicion;
	}

	public void setIdCopia(Long idCopia) {
		this.idCopia = idCopia;
	}

	public void setLibro(LibroDto libro) {
		this.libro = libro;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setFdAdquisicion(Date fdAdquisicion) {
		this.fdAdquisicion = fdAdquisicion;
	}
}
