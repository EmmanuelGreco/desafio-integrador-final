package com.educacionit.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthControllerWeb {

	@GetMapping(value = "/login")
	public String loginForm() {
		return "login";
	}

	@GetMapping(value = "/")
	public String publicAccess(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication.getPrincipal() instanceof String)) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			model.addAttribute("username", userDetails.getUsername());
			model.addAttribute("roles", userDetails.getAuthorities());
		}
		return "index";
	}

	@GetMapping(value = "/admin")
	public String adminAccess() {
		return "panel-administrador";
	}

	@GetMapping(value = "/socio")
	public String userAccess() {
		return "panel-socio";
	}
}
