package com.vertis.demo.domain.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vertis.demo.api.model.input.CategoriaInput;
import com.vertis.demo.domain.model.Categoria;
import com.vertis.demo.domain.service.CategoriaService;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

  @Override
  @Transactional
  public Page<Categoria> filtro(CategoriaInput categoriaInput, Pageable pageable) {
    return null;
  }
  

}
