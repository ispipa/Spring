package com.example.biblioteca.common;

public enum Errores {

	NO_ENCONTRADO(1L,"No encontrado"),
	MAXIMO_PRESTAMOS(2L,"Prestamos maximos alcanzados"),
	COPIA_FD_DEVOLVER(4L,"Copia devolvida tarde"),
	TARJETA_CASTIGADA(5L,"Tarjeta castigada"),
	NULOS(7L,"Valores nulos"),
	BAD_REQUEST(6L,"Bad request"),
	COPIA_PRESTADA(8L,"Copia ya prestada"),
	ERROR_DESCONOCIDO(9L,"Error desconocido"),
	PRESTAMO_YA_DEVUELTO(10L,"El prestamo ya ha sido devuelto"),
	VACIO(3L,"Lista vacia");
	
	private Long id;
	private String mensaje;
	
	
	private Errores(Long id, String mensaje) {
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
