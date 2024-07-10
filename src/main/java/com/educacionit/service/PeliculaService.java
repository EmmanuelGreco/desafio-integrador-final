package com.educacionit.service;

import java.util.List;

import com.educacionit.entity.Pelicula;

public interface PeliculaService {
	
	List<Pelicula> getAllPeliculas();
	Pelicula getPeliculaById(int id);
	void addPelicula(Pelicula pelicula);
	void updatePelicula(int id, Pelicula pelicula);
	void deletePelicula(int id);
}
