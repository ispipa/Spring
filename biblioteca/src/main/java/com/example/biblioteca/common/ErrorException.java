package com.example.biblioteca.common;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class ErrorException extends RuntimeException{

	private static final long serialVersionUID = 105795786474485356L;

	private Long id;
	private HttpStatus status;
	private String mensaje;
	
	public ErrorException(Errores error, HttpStatus status) {
		super();
		this.id = error.getId();
		this.status = status;
		this.mensaje = error.getMensaje();
	}
	
	public ErrorException(Errores error) {
		super();
		this.id = error.getId();
		this.mensaje = error.getMensaje();
	}

	public Long getId() {
		return id;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
