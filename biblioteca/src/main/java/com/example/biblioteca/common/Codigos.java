package com.example.biblioteca.common;

public enum Codigos {
	
	CORRECTO(100L,"Correcto"),
	BAD_CREDENTIALS(200L,"Bad credentials"),
	BAD_REQUEST(201L,"Bad request");
	
	private Long id;
	private String mensaje;
	
	
	private Codigos(Long id, String mensaje) {
		this.id = id;
		this.mensaje = mensaje;
	}

	public Long getId() {
		return id;
	}

	public String getMensaje() {
		return mensaje;
	}
}
