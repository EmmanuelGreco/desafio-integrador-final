package com.educacionit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educacionit.entity.Orden;

@Service("ordenService")
public interface OrdenService {

	List<Orden> getAllOrdenes();

	Optional<Orden> getById(Integer id);

	void saveOrden(Orden orden);

	void deleteOrden(Integer id);
}
