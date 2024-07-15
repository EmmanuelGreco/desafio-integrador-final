package com.educacionit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educacionit.entity.Estado;

@Service("estadoService")
public interface EstadoService {

	List<Estado> getAllEstados();

	Optional<Estado> getById(Integer id);

	void saveEstado(Estado estado);

	void deleteEstado(Integer id);
}
