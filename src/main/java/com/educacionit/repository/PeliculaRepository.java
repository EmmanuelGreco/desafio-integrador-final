package com.educacionit.repository;

import java.util.List;

import com.educacionit.entity.Pelicula;

public interface PeliculaRepository {
	
	List<Pelicula> findAll();
	Pelicula findById(int id);
	void save(Pelicula pelicula);
	void delete(int id);
}
