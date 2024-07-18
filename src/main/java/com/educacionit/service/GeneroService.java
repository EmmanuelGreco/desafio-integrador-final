package com.educacionit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educacionit.entity.Genero;

@Service("generoService")
public interface GeneroService {

	public List<Genero> getAllGeneros();

	public Genero getGeneroById(Integer id);

	public Optional<List<Genero>> findByNombre(String nombre);

	public Genero addGenero(Genero genero);

	public Genero updateGenero(Integer id, Genero generoModificado) throws Exception;

	public void deleteGenero(Integer id);
}
