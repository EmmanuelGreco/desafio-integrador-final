package com.educacionit.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthControllerWeb {

	@GetMapping(value = "/login")
	public String loginForm() {
		return "login";
	}

	@GetMapping(value = "/admin")
	public String adminAccess() {
		return "panel-administrador";
	}

	@GetMapping(value = "/socio")
	public String userAccess() {
		return "panel-socio";
	}

	@GetMapping("/error/403")
	public String error403() {
		return "error/403";
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
}
