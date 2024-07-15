package com.educacionit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.educacionit.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private AuthenticationProvider authProvider;

	public SecurityConfig() {
		super();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authRequest -> authRequest
					.requestMatchers("/").permitAll()
					.requestMatchers("/auth/**", "/login", "/error/403").permitAll()
					.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
					.requestMatchers("/css/**", "/js/**").permitAll()
					.requestMatchers("/api/peliculas", "/api/peliculas/search").permitAll()
					.requestMatchers("/favicon.ico").permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/socio/**").hasRole("SOCIO")
					.anyRequest().authenticated())
			.sessionManagement(sessionManager -> sessionManager
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authenticationProvider(authProvider)
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling(exceptionHandler -> exceptionHandler
					.accessDeniedHandler(accessDeniedHandler()))
		.build();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return (request, response, accessDeniedException) -> {
			response.sendRedirect("/error/403");
		};
	}
}
