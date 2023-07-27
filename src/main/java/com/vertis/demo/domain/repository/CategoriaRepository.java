package com.vertis.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vertis.demo.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}