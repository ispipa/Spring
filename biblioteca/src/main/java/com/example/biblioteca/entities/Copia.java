package com.example.biblioteca.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "copias")
public class Copia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_copia", length = 20)
	private Long idCopia;
	
	@ManyToOne
	@JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
	@JsonIgnoreProperties({"copias"})
	private Libro libro;
	
	@OneToOne(mappedBy = "copia")
	@JsonIgnoreProperties({"copia","lector","idCopia"})
	private Prestamo prestamo;
	
	@Column(length = 40)
	private String editorial;
	
	@Column(name = "fd_adquisicion")
	private Date fdAdquisicion;

	public Copia() {
		super();
	}

	public Copia(Long idCopia, Libro libro, Prestamo prestamo, String editorial, Date fdAdquisicion) {
		super();
		this.idCopia = idCopia;
		this.libro = libro;
		this.prestamo = prestamo;
		this.editorial = editorial;
		this.fdAdquisicion = fdAdquisicion;
	}



	public Long getIdCopia() {
		return idCopia;
	}

	public void setIdCopia(Long idCopia) {
		this.idCopia = idCopia;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFdAdquisicion() {
		return fdAdquisicion;
	}

	public void setFdAdquisicion(Date fdAdquisicion) {
		this.fdAdquisicion = fdAdquisicion;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
}
