package com.vertis.demo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vertis.demo.api.model.input.CategoriaInput;
import com.vertis.demo.domain.model.Categoria;

@Service
public class CategoriaService {

  public Page<Categoria> filtro(CategoriaInput categoriaInput, Pageable pageable) {
    return null;
  }
}
