package com.educacionit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educacionit.entity.Pelicula;

@Service("peliculaService")
public interface PeliculaService {

	public List<Pelicula> getAllPeliculas();

	public Pelicula getPeliculaById(Integer id);
	
	public Optional<List<Pelicula>> findByTitulo(String titulo);

	public Pelicula addPelicula(Pelicula pelicula);

	public Pelicula updatePelicula(Integer id, Pelicula peliculaModificada) throws Exception;

	public void deletePelicula(Integer id);
}
