package com.educacionit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Pelicula;
import com.educacionit.repository.PeliculaRepository;
import com.educacionit.service.PeliculaService;

@Service("peliculaService")
public class PeliculaServiceImpl implements PeliculaService {

	//private static final Logger logger = LoggerFactory.getLogger(PeliculaServiceImpl.class);

	@Autowired
	@Qualifier("peliculaRepository")
	private PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> getAllPeliculas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula getPeliculaById(Integer id) {
		Pelicula unaPelicula = peliculaRepository.findById(id).orElse(null);
		return unaPelicula;
	}

	@Override
	public Optional<List<Pelicula>> findByTitulo(String titulo) {
		return peliculaRepository.findByTituloContainingIgnoreCase(titulo);
	}

	@Override
	public Pelicula addPelicula(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public Pelicula updatePelicula(Integer id, Pelicula peliculaModificada) throws Exception {
		Optional<Pelicula> existingPeliculaOptional = peliculaRepository.findById(id);

		if (existingPeliculaOptional.isPresent()) {
			Pelicula existingPelicula = existingPeliculaOptional.get();
			existingPelicula.setTitulo(peliculaModificada.getTitulo());
			existingPelicula.setDirector(peliculaModificada.getDirector());
			existingPelicula.setUrl(peliculaModificada.getUrl());
			existingPelicula.setPortada(peliculaModificada.getPortada());
			existingPelicula.setPrecio(peliculaModificada.getPrecio());

			return peliculaRepository.save(existingPelicula);
		} else {
			throw new Exception("La Película con ID: " + id + " NO existe en la BD!");
		}
	}

	@Override
	public void deletePelicula(Integer id) {
		peliculaRepository.deleteById(id);
	}
}
