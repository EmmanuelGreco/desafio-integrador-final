package com.educacionit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.entity.Cupon;

@Repository("cuponRepository")
public interface CuponRepository extends JpaRepository<Cupon, Integer> {

	Optional<Cupon> findByNameIgnoreCase(String name);
}
