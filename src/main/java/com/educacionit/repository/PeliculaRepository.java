package com.educacionit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.entity.Pelicula;

@Repository("peliculaRepository")
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
	
	Optional<List<Pelicula>> findByTituloContainingIgnoreCase(String titulo);
}
