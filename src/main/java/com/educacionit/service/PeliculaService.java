package com.educacionit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.educacionit.entity.Pelicula;

@Service("peliculaService")
public interface PeliculaService {

	List<Pelicula> getAllPeliculas();

	Pelicula getPeliculaById(int id);

	void addPelicula(Pelicula pelicula);

	void updatePelicula(int id, Pelicula pelicula);

	void deletePelicula(int id);
}
