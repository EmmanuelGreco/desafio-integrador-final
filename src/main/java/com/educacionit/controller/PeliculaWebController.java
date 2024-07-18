package com.educacionit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/peliculas")
public class PeliculaWebController {

	@GetMapping
	public String getIndexPage(HttpSession session) {
		return null;
	}
}
