package com.educacionit.controller;

import java.util.List;

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

import com.educacionit.entity.Genero;
import com.educacionit.service.GeneroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/generos")
@Tag(name = "Administrador de Géneros", description = "Endpoints para administrar Géneros")
public class GeneroApiController {

	// private static final Logger logger = LoggerFactory.getLogger(GeneroApiController.class);

	@Autowired
	@Qualifier("generoService")
	private GeneroService generoService;

	@Operation(summary = "Obtener lista de todos los Géneros")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista de Géneros obtenida correctamente"),
			@ApiResponse(responseCode = "404", description = "Géneros no encontrados", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@GetMapping
	public ResponseEntity<List<Genero>> getAllGeneros() {
		List<Genero> generos = generoService.getAllGeneros();
		return new ResponseEntity<>(generos, HttpStatus.OK);
	}

	@Operation(summary = "Obtener Género por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Género obtenido correctamente"),
			@ApiResponse(responseCode = "404", description = "Género no encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<Genero> getGeneroById(@PathVariable("id") Integer id) {
		Genero unGenero = generoService.getGeneroById(id);

		if (unGenero == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(unGenero, HttpStatus.OK);
	}

	@Operation(summary = "Agregar un Género")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Género creado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@PostMapping("/")
	public ResponseEntity<Void> addGenero(@RequestBody Genero genero) {
		generoService.addGenero(genero);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar un Género por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Género actualizado exitosamente"),
			@ApiResponse(responseCode = "404", description = "Género no encontrada", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@SecurityRequirement(name = "bearerAuth")
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateGenero(@PathVariable("id") Integer id, @RequestBody Genero generoModificado)
			throws Exception {
		Genero existingGenero = generoService.getGeneroById(id);

		if (existingGenero == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		generoService.updateGenero(id, generoModificado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Eliminar un Género por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Género eliminada exitosamente"),
			@ApiResponse(responseCode = "404", description = "Género no encontrada", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGenero(@PathVariable("id") Integer id) {
		Genero genero = generoService.getGeneroById(id);

		if (genero == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		generoService.deleteGenero(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
