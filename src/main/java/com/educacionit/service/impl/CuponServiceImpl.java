package com.educacionit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Cupon;
import com.educacionit.repository.CuponRepository;
import com.educacionit.service.CuponService;

@Service("cuponService")
public class CuponServiceImpl implements CuponService {

	@Autowired
    @Qualifier("cuponRepository")
    private CuponRepository cuponRepository;

    @Override
    public List<Cupon> getAllCupones() {
        return cuponRepository.findAll();
    }

    @Override
    public Optional<Cupon> getById(Integer id) {
        return cuponRepository.findById(id);
    }

    @Override
    public void saveCupon(Cupon cupon) {
        cuponRepository.save(cupon);
    }

    @Override
    public void deleteCupon(Integer id) {
        cuponRepository.deleteById(id);
    }
}
