package com.example.biblioteca.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PrestamoDto {
	
	private Long idCopia;
	
	private CopiaDto copia;
	
	private LectorDto lector;

	private Date fdPrestacion;

	private Date fdDevolver;

	private Boolean active;

	public PrestamoDto() {
		super();
	}

	public PrestamoDto(Long idCopia, CopiaDto copia, LectorDto lector, Date fdPrestacion, Date fdDevolver,
			Boolean active) {
		super();
		this.idCopia = idCopia;
		this.copia = copia;
		this.lector = lector;
		this.fdPrestacion = fdPrestacion;
		this.fdDevolver = fdDevolver;
		this.active = active;
	}

	public Long getIdCopia() {
		return idCopia;
	}

	public CopiaDto getCopia() {
		return copia;
	}

	public LectorDto getLector() {
		return lector;
	}

	public Date getFdPrestacion() {
		return fdPrestacion;
	}

	public Date getFdDevolver() {
		return fdDevolver;
	}

	public Boolean getActive() {
		return active;
	}

	public void setIdCopia(Long idCopia) {
		this.idCopia = idCopia;
	}

	public void setCopia(CopiaDto copia) {
		this.copia = copia;
	}

	public void setLector(LectorDto lector) {
		this.lector = lector;
	}

	public void setFdPrestacion(Date fdPrestacion) {
		this.fdPrestacion = fdPrestacion;
	}

	public void setFdDevolver(Date fdDevolver) {
		this.fdDevolver = fdDevolver;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
