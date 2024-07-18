package com.educacionit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Estado;
import com.educacionit.repository.EstadoRepository;
import com.educacionit.service.EstadoService;

@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	@Qualifier("estadoRepository")
	private EstadoRepository estadoRepository;

	@Override
	public List<Estado> getAllEstados() {
		return estadoRepository.findAll();
	}

	@Override
	public Optional<Estado> getById(Integer id) {
		return estadoRepository.findById(id);
	}

	@Override
	public void saveEstado(Estado estado) {
		estadoRepository.save(estado);
	}

	@Override
	public void deleteEstado(Integer id) {
		estadoRepository.deleteById(id);
	}
}
