package com.educacionit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Genero;
import com.educacionit.repository.GeneroRepository;
import com.educacionit.service.GeneroService;

@Service("generoService")
public class GeneroServiceImpl implements GeneroService {

	//private static final Logger logger = LoggerFactory.getLogger(GeneroServiceImpl.class);

	@Autowired
	@Qualifier("generoRepository")
	private GeneroRepository generoRepository;

	@Override
	public List<Genero> getAllGeneros() {
		return generoRepository.findAll();
	}

	@Override
	public Genero getGeneroById(Integer id) {
		Genero unGenero = generoRepository.findById(id).orElse(null);
		return unGenero;
	}

	@Override
	public Optional<List<Genero>> findByNombre(String nombre) {
		return generoRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public Genero addGenero(Genero genero) {
		return generoRepository.save(genero);
	}

	@Override
	public Genero updateGenero(Integer id, Genero generoModificado) throws Exception {
		Optional<Genero> existingGeneroOptional = generoRepository.findById(id);

		if (existingGeneroOptional.isPresent()) {
			Genero existingGenero = existingGeneroOptional.get();
			existingGenero.setNombre(generoModificado.getNombre());

			return generoRepository.save(existingGenero);
		} else {
			throw new Exception("El Género con ID: " + id + " NO existe en la BD!");
		}
	}

	@Override
	public void deleteGenero(Integer id) {
		generoRepository.deleteById(id);
	}
}
