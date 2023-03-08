package com.example.biblioteca.responses;

import com.example.biblioteca.common.Codigos;
import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;

public class ResponseBase {

	private Long id;
	private String mensaje;
	
	public ResponseBase(ErrorException e) {
		super();
		this.id = e.getId();
		this.mensaje = e.getMensaje();
	}
	
	public ResponseBase(Errores e) {
		super();
		this.id = e.getId();
		this.mensaje = e.getMensaje();
	}
	
	public ResponseBase(Codigos c) {
		super();
		this.id = c.getId();
		this.mensaje = c.getMensaje();
	}


	public Long getId() {
		return id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
