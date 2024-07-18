package com.educacionit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Orden;
import com.educacionit.repository.OrdenRepository;
import com.educacionit.service.OrdenService;

@Service("ordenService")
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	@Qualifier("ordenRepository")
	private OrdenRepository ordenRepository;

	@Override
	public List<Orden> getAllOrdenes() {
		return ordenRepository.findAll();
	}

	@Override
	public Optional<Orden> getById(Integer id) {
		return ordenRepository.findById(id);
	}

	@Override
	public void saveOrden(Orden orden) {

		//Implementar DTO con cupones

		ordenRepository.save(orden);
	}

	@Override
	public void deleteOrden(Integer id) {
		ordenRepository.deleteById(id);
	}
}
