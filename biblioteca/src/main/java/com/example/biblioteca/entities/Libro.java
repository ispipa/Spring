package com.example.biblioteca.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.biblioteca.common.Area;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20, name = "id_libro")
	private Long idLibro;
	
	@OneToMany(mappedBy = "libro", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"libro","prestamo"})
	private List<Copia> copias;
	
	@Column(length = 40)
	private String titulo;
	
	@Column(length = 40)
	private String autor;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Area area;
	
	public Libro() {
		super();
	}

	public Libro(Long idLibro, List<Copia> copias, String titulo, String autor, Area area) {
		super();
		this.idLibro = idLibro;
		this.copias = copias;
		this.titulo = titulo;
		this.autor = autor;
		this.area = area;
	}

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public List<Copia> getCopias() {
		return copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
