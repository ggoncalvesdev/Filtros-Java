package com.vertis.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vertis.demo.api.assembler.CategoriaModelAssembler;
import com.vertis.demo.api.model.CategoriaModel;
import com.vertis.demo.api.model.input.CategoriaInput;
import com.vertis.demo.domain.model.Categoria;
import com.vertis.demo.domain.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
  
  @Autowired
	private CategoriaService categoriaService;

  @Autowired
	private CategoriaModelAssembler categoriaModelAssembler;

  @GetMapping("/lista-filtrada")
	public Page<CategoriaModel> listaFiltro(@RequestBody CategoriaInput categoriaInput, @PageableDefault(size = 10) Pageable pageable) {
		Page<Categoria> categoriasPage = categoriaService.filtro(categoriaInput, pageable);
			
			return categoriaModelAssembler.toPageModel(categoriasPage);
	}

}
