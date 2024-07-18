package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.entity.Orden;

@Repository("ordenRepository")
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
