package com.example.biblioteca.common;

public enum Area {

	AVENTURAS(1L,"Aventuras"), 
	CIENCIA_FICCION(1L,"Ciencia Ficcion"), 
	CUENTO(1L,"Cuento"), 
	HUMOR(1L,"Humor"), 
	SUSPENSE(1L,"Suspense"), 
	TERROR(1L,"Terror"),
	NOVELA(1L,"Novela"),
	ROMANCE(1L,"Romance");

	private Long id;
	private String name;

	private Area(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}
	
}
