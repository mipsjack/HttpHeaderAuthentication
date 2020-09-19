package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.addFilterBefore(new HeaderVKSTFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.antMatcher("/api/**").authorizeRequests().anyRequest().authenticated()
		.and().httpBasic();
	}
}
