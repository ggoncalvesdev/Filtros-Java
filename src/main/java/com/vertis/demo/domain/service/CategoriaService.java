package com.vertis.demo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vertis.demo.api.model.input.CategoriaInput;
import com.vertis.demo.domain.model.Categoria;

public interface CategoriaService {

  public Page<Categoria> filtro(CategoriaInput categoriaInput, Pageable pageable);

}
