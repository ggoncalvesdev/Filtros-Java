package com.vertis.demo.api.assembler;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.vertis.demo.api.model.CategoriaModel;
import com.vertis.demo.domain.model.Categoria;

@Component
public class CategoriaModelAssembler{
	
	@Autowired
	private ModelMapper modelMapper;

  public CategoriaModel toModel(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaModel.class);
	}

	public List<CategoriaModel> toCollectionModel(List<Categoria> categorias) {
		return categorias
				.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

	public Page<CategoriaModel> toPageModel(Page<Categoria> categoriasPage) {
		List<CategoriaModel> categoriasModel = toCollectionModel(categoriasPage.getContent());
			return new PageImpl<>(categoriasModel, categoriasPage.getPageable(), categoriasPage.getTotalElements());
	}
}
