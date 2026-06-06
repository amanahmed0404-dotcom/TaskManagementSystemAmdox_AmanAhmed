package com.ayushi.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@Autowired
	private JWTAuthFilter authFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http.csrf(csrf -> csrf.disable())
	        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/user_auth/**", "/api/health").permitAll()
	            .anyRequest().authenticated()
	        );

	    return http.build();
	}


	public JWTUtil getJwtUtil() {
		return jwtUtil;
	}


	public void setJwtUtil(JWTUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}


	public JWTAuthFilter getAuthFilter() {
		return authFilter;
	}


	public void setAuthFilter(JWTAuthFilter authFilter) {
		this.authFilter = authFilter;
	}

}
