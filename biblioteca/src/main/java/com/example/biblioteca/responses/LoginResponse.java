package com.example.biblioteca.responses;

import com.example.biblioteca.common.Codigos;

public class LoginResponse extends ResponseBase{
	
	private String token;
	private String username;
	private String password;
	private String rol;
	
	public LoginResponse(Codigos codigo) {
		super(codigo);
	}

	public LoginResponse(Codigos codigo, String token, String username, String password,
			String rol) {
		super(codigo);
		this.token = token;
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
