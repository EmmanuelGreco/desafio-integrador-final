package com.educacionit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educacionit.entity.Cupon;

@Service("cuponService")
public interface CuponService {

	List<Cupon> getAllCupones();

	Optional<Cupon> getById(Integer id);

	void saveCupon(Cupon cupon);

	void deleteCupon(Integer id);
}
