package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.dto.AuthResponse;
import com.educacionit.dto.LoginRequest;
import com.educacionit.dto.RegisterRequest;
import com.educacionit.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "1. Autenticación de usuarios", description = "Endpoints autenticación y registro de usuarios")
public class AuthController {

	@Autowired
	private AuthService authService = null;

	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {		
		try {
			return ResponseEntity.ok(authService.register(request));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Operation(summary = "Inicio de sesión con email y contraseña")
	@PostMapping(value = "/login")
	ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}
}
