package com.example.biblioteca.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tarjetas")
public class Tarjeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarjeta", length = 20)
	private Long idTarjeta;
	
	@OneToOne
	@JoinColumn(name = "id_lector", referencedColumnName = "id_lector")
	@JsonIgnoreProperties({"tarjeta","prestamos"})
	private Lector lector;
	
	@Column(name = "fd_creacion")
	private Date fdCreacion;
	
	@Column(name = "fd_caducidad")
	private Date fdCaducidad;
	
	@Column(name = "fd_castigo")
	private Date fdCastigo;
	
	@Column(name = "active")
	private Boolean active;

	public Tarjeta() {
		super();
	}

	public Tarjeta(Long idTarjeta, Lector lector, Date fdCreacion, Date fdCaducidad, Date fdCastigo, Boolean active) {
		super();
		this.idTarjeta = idTarjeta;
		this.lector = lector;
		this.fdCreacion = fdCreacion;
		this.fdCaducidad = fdCaducidad;
		this.fdCastigo = fdCastigo;
		this.active = active;
	}

	public Long getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Date getFdCreacion() {
		return fdCreacion;
	}

	public void setFdCreacion(Date fdCreacion) {
		this.fdCreacion = fdCreacion;
	}

	public Date getFdCaducidad() {
		return fdCaducidad;
	}

	public void setFdCaducidad(Date fdCaducidad) {
		this.fdCaducidad = fdCaducidad;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getFdCastigo() {
		return fdCastigo;
	}

	public void setFdCastigo(Date fdCastigo) {
		this.fdCastigo = fdCastigo;
	}
	
}
