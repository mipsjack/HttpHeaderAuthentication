package com.example.demo;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class HeaderVKSTFilter extends GenericFilterBean{
	public static final String AUTHENTICATION_HEADER_PARAMETER =  "User-Agent";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (request instanceof HttpServletRequest) {
			final HttpServletRequest httpReq =  (HttpServletRequest) request;
			
			String ref = httpReq.getHeader(AUTHENTICATION_HEADER_PARAMETER);
			if (ref != null) {
				final String username = ref.trim();
				if (!username.isEmpty()) {
					final HeaderVKSTToken token = new HeaderVKSTToken(username, Collections.singletonList(new SimpleGrantedAuthority("Auth_Role")));
					SecurityContextHolder.getContext().setAuthentication(token);
				}
			}
			
		}
		
		chain.doFilter(request, response);
		
	}

}
