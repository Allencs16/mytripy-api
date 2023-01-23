package com.breallencs.mytripyapi.core.jwt.resources;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private String email;
	private String password;

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String email, String password) {
		this.setUsername(email);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}