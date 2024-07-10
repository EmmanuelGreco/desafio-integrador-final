package com.educacionit.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.educacionit.entity.Pelicula;
import com.educacionit.repository.PeliculaRepository;

@Repository("peliculaRepository")
public class PeliculaRepositoryImpl implements PeliculaRepository {

	private List<Pelicula> peliculas = new ArrayList<>();

	@Override
	public List<Pelicula> findAll() {
		return peliculas;
	}

	@Override
	public Pelicula findById(int id) {
		return peliculas.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
	}

	@Override
	public void save(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	@Override
	public void delete(int id) {
		peliculas.removeIf(a -> a.getId() == id);
	}
}
