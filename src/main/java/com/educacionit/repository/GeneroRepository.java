package com.educacionit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.entity.Genero;

@Repository("generoRepository")
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

	Optional<List<Genero>> findByNombreContainingIgnoreCase(String name);
}
