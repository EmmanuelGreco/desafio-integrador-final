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

import com.educacionit.entity.Cupon;
import com.educacionit.service.CuponService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cupones")
@Tag(name = "Gestión de Cupones", description = "Endpoints para administrar cupones")
public class CuponApiController {

	@Autowired
	@Qualifier("cuponService")
	private CuponService cuponService;

	@Operation(summary = "Obtener lista de todos los cupones")
	@GetMapping
	public ResponseEntity<List<Cupon>> getAllCupones() {
		List<Cupon> cupones = cuponService.getAllCupones();
		return new ResponseEntity<>(cupones, HttpStatus.OK);
	}

	@Operation(summary = "Obtener cupón por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cupon>> getCuponById(@PathVariable("id") Integer id) throws Exception {
		Optional<Cupon> cupon = cuponService.getById(id);
		
		if (cupon.isPresent()) {
			return new ResponseEntity<>(cupon, HttpStatus.OK);
		}
		return new ResponseEntity<>(cupon, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Crear un nuevo cupón")
	@PostMapping
	public ResponseEntity<Void> addCupon(@RequestBody Cupon cupon) {
		cuponService.saveCupon(cupon);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "Modificar cupón por ID")
	@PutMapping("/{id}")
	@SecurityRequirement(name = "bearerAuth")
	public ResponseEntity<Void> updateCupon(@PathVariable("id") Integer id, @RequestBody Cupon cupon) {
		Optional<Cupon> cuponActual = cuponService.getById(id);

		if (cuponActual.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		cupon.setId(id);
		cuponService.saveCupon(cupon);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Eliminar cupón por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCupon(@PathVariable("id") Integer id) {
		cuponService.deleteCupon(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
