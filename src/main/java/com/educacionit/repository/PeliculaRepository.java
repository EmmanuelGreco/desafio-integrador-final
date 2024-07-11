package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.entity.Pelicula;

@Repository("peliculaRepository")
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
}
