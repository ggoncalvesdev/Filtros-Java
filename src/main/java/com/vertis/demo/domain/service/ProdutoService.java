package com.vertis.demo.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vertis.demo.api.model.input.ProdutoInput;
import com.vertis.demo.domain.model.Produto;

public interface ProdutoService {

	public Page<Produto> filtro(ProdutoInput produtoInput, Pageable pageable);
}
