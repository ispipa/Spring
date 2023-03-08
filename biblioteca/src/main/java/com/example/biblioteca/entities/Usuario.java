package com.example.biblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	private String username;

	private String password;
	
	private String email;
	
	private String rol;
	
	public Usuario() {
	}
	
	public Usuario(String username, String password, String email, String rol) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRol() {
		return rol;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}