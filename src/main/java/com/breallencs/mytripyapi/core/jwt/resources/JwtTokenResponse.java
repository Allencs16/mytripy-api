package com.breallencs.mytripyapi.core.jwt.resources;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtTokenResponse implements Serializable{
  
  private final String token;
	
	private final Collection<? extends GrantedAuthority> authorities;


	public JwtTokenResponse(String token, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.authorities = authorities;
	}

	public String getToken() {
		return this.token;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
