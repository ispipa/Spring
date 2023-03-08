package com.example.biblioteca.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "lectores")
public class Lector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lector", length = 20)
	private Long idLector;
	
	@OneToOne(mappedBy = "lector")
	@JsonIgnoreProperties({"lector"})
	private Tarjeta tarjeta;
	
	@OneToMany(mappedBy = "lector")
	@JsonIgnoreProperties({"lector","copia"})
	private List<Prestamo> prestamos;
	
	@Column(name = "nombre_completo", length = 40)
	private String nombreCompleto;
	
	@Column(length = 9, unique = true)
	private String dni;
	
	@Column(name = "fd_nacimiento")
//	@JsonBackReference
//	@JsonM
	private Date fdNacimiento;
	
	public Lector() {
		super();
	}

	public Lector(Long idLector, Tarjeta tarjeta, List<Prestamo> prestamos, String nombreCompleto, String dni,
			Date fdNacimiento) {
		super();
		this.idLector = idLector;
		this.tarjeta = tarjeta;
		this.prestamos = prestamos;
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.fdNacimiento = fdNacimiento;
	}

	public Long getIdLector() {
		return idLector;
	}

	public void setIdLector(Long idLector) {
		this.idLector = idLector;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFdNacimiento() {
		return fdNacimiento;
	}

	public void setFdNacimiento(Date fdNacimiento) {
		this.fdNacimiento = fdNacimiento;
	}
	
	
}
