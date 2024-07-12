package com.educacionit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.entity.Pelicula;
import com.educacionit.service.PeliculaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Administrador de Películas", description = "Endpoints para administrar películas")
public class PeliculaApiController {

	private static final Logger logger = LoggerFactory.getLogger(PeliculaApiController.class);

	@Autowired
	@Qualifier("peliculaService")
	private PeliculaService peliculaService;

	@GetMapping
	public ResponseEntity<List<Pelicula>> getAllPeliculas() {
		List<Pelicula> peliculas = peliculaService.getAllPeliculas();
		return new ResponseEntity<>(peliculas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") int id) {
		Pelicula pelicula = peliculaService.getPeliculaById(id);
		if (pelicula == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		logger.info("Consulta por id de Película: {}. Respuesta: {} {}", id, pelicula, ". Fin log");
		logger.error("Se produjo un error. ", new Exception("Error"));
		return new ResponseEntity<>(pelicula, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> addPelicula(@RequestBody Pelicula pelicula) {
		peliculaService.addPelicula(pelicula);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePelicula(@PathVariable("id") int id, @RequestBody Pelicula pelicula) {
		peliculaService.updatePelicula(id, pelicula);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePelicula(@PathVariable("id") int id) {
		peliculaService.deletePelicula(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
