package com.breallencs.mytripyapi.core.jwt.resources;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtTokenResponse implements Serializable{
  
  private final String token;


	public JwtTokenResponse(String token, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}
