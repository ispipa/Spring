package com.example.biblioteca.responses;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;

public class Response<T> extends ResponseBase {

	private T cuerpo;
	
	public Response(Errores e, T cuerpo) {
		super(e);
		this.cuerpo = cuerpo;
	}
	public Response(ErrorException e, T cuerpo) {
		super(e);
		this.cuerpo = cuerpo;
	}

	public T getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(T cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	

}
