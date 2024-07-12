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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/peliculas-listar")
@Tag(name = "Administrador de Películas", description = "Endpoints para administrar películas")
public class PeliculaApiController {

	private static final Logger logger = LoggerFactory.getLogger(PeliculaApiController.class);

	@Autowired
	@Qualifier("peliculaService")
	private PeliculaService peliculaService;

	@Operation(summary = "Obtener lista de todas las películas")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista de películas obtenida correctamente"),
			@ApiResponse(responseCode = "404", description = "Películas no encontradas", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@GetMapping
	public ResponseEntity<List<Pelicula>> getAllPeliculas() {
		List<Pelicula> peliculas = peliculaService.getAllPeliculas();
		return new ResponseEntity<>(peliculas, HttpStatus.OK);
	}

	@Operation(summary = "Obtener película por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Película obtenida correctamente"),
			@ApiResponse(responseCode = "404", description = "Película no encontrada", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") Integer id) {
		Pelicula unaPelicula = peliculaService.getPeliculaById(id);
		
		if (unaPelicula == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(unaPelicula, HttpStatus.OK);
	}

	@Operation(summary = "Agregar una película")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Película creada exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@PostMapping("/")
	public ResponseEntity<Void> addPelicula(@RequestBody Pelicula pelicula) {
		peliculaService.addPelicula(pelicula);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar una película")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Película actualizada exitosamente"),
			@ApiResponse(responseCode = "404", description = "Película no encontrada", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePelicula(@PathVariable("id") Integer id, @RequestBody Pelicula peliculaModificada) throws Exception {
		Pelicula existingPelicula = peliculaService.getPeliculaById(id);
		
		if (existingPelicula == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		peliculaService.updatePelicula(id, peliculaModificada);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Eliminar una película")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Película eliminada exitosamente"),
			@ApiResponse(responseCode = "404", description = "Película no encontrada", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePelicula(@PathVariable("id") Integer id) {
		Pelicula pelicula = peliculaService.getPeliculaById(id);
		
		if (pelicula == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		peliculaService.deletePelicula(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
