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

import com.educacionit.entity.Orden;
import com.educacionit.service.OrdenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/ordenes")
@Tag(name = "Administrador de Órdenes", description = "Endpoints para administrar de órdenes")
public class OrdenApiController {

	@Autowired
	@Qualifier("ordenService")
	private OrdenService ordenService;

	@Operation(summary = "Obtener lista de todas las órdenes")
	@GetMapping
	public ResponseEntity<List<Orden>> getAllOrdenes() {
		List<Orden> ordenes = ordenService.getAllOrdenes();
		return new ResponseEntity<>(ordenes, HttpStatus.OK);
	}

	@Operation(summary = "Obtener orden por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Orden>> getOrdenById(@PathVariable("id") Integer id) throws Exception {
		Optional<Orden> orden = ordenService.getById(id);
		
		if (orden.isPresent()) {
			return new ResponseEntity<>(orden, HttpStatus.OK);
		}
		return new ResponseEntity<>(orden, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Crear una nueva orden")
	@PostMapping
	public ResponseEntity<Void> addOrden(@RequestBody Orden orden) {
		ordenService.saveOrden(orden);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "Modificar orden por ID")
	@PutMapping("/{id}")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Void> updateOrden(@PathVariable("id") Integer id, @RequestBody Orden orden) {
		Optional<Orden> ordenActual = ordenService.getById(id);

		if (ordenActual.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		orden.setId(id);
		ordenService.saveOrden(orden);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Eliminar orden por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrden(@PathVariable("id") Integer id) {
		ordenService.deleteOrden(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
