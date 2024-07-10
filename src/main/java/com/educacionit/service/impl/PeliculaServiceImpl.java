package com.educacionit.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Pelicula;
import com.educacionit.service.PeliculaService;

@Service("peliculaService")
public class PeliculaServiceImpl implements PeliculaService {
	
	private static final Logger logger = LoggerFactory.getLogger(PeliculaServiceImpl.class);

	@Autowired
	@Qualifier("peliculaRepository")
	private PeliculaRepository peliculaRepository;
	
	@Override
	public List<Pelicula> getAllPeliculas() {
		return peliculaRepository.finAll();
	}

	@Override
	public Pelicula getPeliculaById(int id) {
		return peliculaRepository.findById(id);
	}

	@Override
	public void addPelicula(Pelicula pelicula) {
		//logger.info("Agregar película con título {}: . Toda la clase: {}", pelicula.getTitulo(), pelicula);		
		peliculaRepository.save(pelicula);		
	}

	@Override
	public void updatePelicula(int id, Pelicula pelicula) {
		Pelicula existePelicula = peliculaRepository.findById(id);
		if (existePelicula != null) {
			existePelicula.setTitulo(pelicula.getTitulo());
			existePelicula.setDirector(pelicula.getDirector());
			existePelicula.setUrl(pelicula.getUrl());
			existePelicula.setPortada(pelicula.getPortada());
			existePelicula.setPrecio(pelicula.getPrecio());
		}
	}

	@Override
	public void deletePelicula(int id) {
		peliculaRepository.delete(id);		
	}
}
