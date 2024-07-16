package com.educacionit.controller;

import java.util.List;
import java.util.Optional;

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

import com.educacionit.entity.Estado;
import com.educacionit.service.EstadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/estados")
@Tag(name = "Administrador de Estados de Órdenes", description = "Endpoints para administrar estados de órdenes")
public class EstadoApiController {

	@Autowired
	@Qualifier("estadoService")
	private EstadoService estadoService;

	@Operation(summary = "Obtener lista de todos los estados")
	@GetMapping
	public ResponseEntity<List<Estado>> getAllEstados() {
		List<Estado> estados = estadoService.getAllEstados();
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}

	@Operation(summary = "Obtener estado por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Estado>> getEstadoById(@PathVariable("id") Integer id) throws Exception {
		Optional<Estado> estado = estadoService.getById(id);
		
		if (estado.isPresent()) {
			return new ResponseEntity<>(estado, HttpStatus.OK);
		}
		return new ResponseEntity<>(estado, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Crear un nuevo estado")
	@PostMapping
	public ResponseEntity<Void> addEstado(@RequestBody Estado estado) {
		estadoService.saveEstado(estado);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "Modificar estado por ID")
	@PutMapping("/{id}")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Void> updateEstado(@PathVariable("id") Integer id, @RequestBody Estado estado) {
		Optional<Estado> estadoActual = estadoService.getById(id);

		if (estadoActual.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		estado.setId(id);
		estadoService.saveEstado(estado);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Eliminar estado por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEstado(@PathVariable("id") Integer id) {
		estadoService.deleteEstado(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
