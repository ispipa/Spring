package com.example.biblioteca.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "prestamos")
public class Prestamo{

	@Id
	@Column(name = "id_copia")
	private Long idCopia;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_copia", referencedColumnName = "id_copia")
	@JsonIgnoreProperties({"prestamo","idCopia"})
	private Copia copia;
	
	@ManyToOne
	@JoinColumn(name = "id_lector", referencedColumnName = "id_lector")
	@JsonIgnoreProperties({"prestamos","tarjeta"})
	private Lector lector;
	
	@Column(name = "fd_prestamo")
	private Date fdPrestacion;
	
	@Column(name = "fd_devolver")
	private Date fdDevolver;
	
	@Column(name = "active")
	private Boolean active;

	public Prestamo() {
		super();
	}

	public Prestamo(Long idCopia, Copia copia, Lector lector, Date fdPrestacion, Date fdDevolver, Boolean active) {
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

	public Copia getCopia() {
		return copia;
	}

	public Lector getLector() {
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

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	public void setLector(Lector lector) {
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
