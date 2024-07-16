package com.educacionit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthControllerWeb {

	@GetMapping(value = "/login")
	public String loginForm() {
		return "login";
	}

	@GetMapping("/error/403")
	public String error403() {
		return "error/403";
	}

	@GetMapping(value = "/")
	public String publicAccess(Model model) {
		return "index";
	}
}
