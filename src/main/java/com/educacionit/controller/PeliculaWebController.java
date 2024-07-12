package com.educacionit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class PeliculaWebController {

	@GetMapping
	public String getIndexPage(Model model) {
		return "index";
	}
}
