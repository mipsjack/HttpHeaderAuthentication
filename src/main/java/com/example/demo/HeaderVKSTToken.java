package com.example.demo;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class HeaderVKSTToken extends AbstractAuthenticationToken{
	private String userName;
	
	public HeaderVKSTToken(String userName, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.userName = userName;
		setAuthenticated(true);
	}
	
	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return userName;
	}


}
