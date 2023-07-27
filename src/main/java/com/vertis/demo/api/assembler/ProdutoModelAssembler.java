package com.vertis.demo.api.assembler;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.vertis.demo.api.model.ProdutoModel;
import com.vertis.demo.domain.model.Produto;

/**
 * Classe responsável por converter objetos da entidade Produto para objetos da classe ProdutoModel (DTO)
 * e vice-versa. Utiliza o ModelMapper para realizar as conversões.
 */
@Component
public class ProdutoModelAssembler{
	
	// Responsável por mapear os atributos entre as classes durante a conversão.
	@Autowired
	private ModelMapper modelMapper;


	/**
	 * Converte um objeto da entidade Produto para um objeto da classe ProdutoModel (DTO).
	 *
	 * @param produto Objeto da entidade Produto a ser convertido.
	 * @return Objeto ProdutoModel que representa o produto convertido.
	 */
  public ProdutoModel toModel(Produto produto) {
		return modelMapper.map(produto, ProdutoModel.class);
	}

	/**
	 * Converte uma lista de objetos da entidade Produto para uma lista de objetos da classe ProdutoModel (DTO).
	 *
	 * @param produtos Lista de objetos da entidade Produto a serem convertidos.
	 * @return Lista de objetos ProdutoModel que representam os produtos convertidos.
	 */
	public List<ProdutoModel> toCollectionModel(List<Produto> produtos) {
		return produtos
				.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

	/**
	 * Converte uma página paginada de objetos da entidade Produto para uma página paginada de objetos da classe ProdutoModel (DTO).
	 *
	 * @param produtosPage Página paginada de objetos da entidade Produto a serem convertidos.
	 * @return Página paginada de objetos ProdutoModel que representam os produtos convertidos.
	 */
	public Page<ProdutoModel> toPageModel(Page<Produto> produtosPage) {
		// Converte a lista de produtos na página paginada usando o método toCollectionModel.	
		List<ProdutoModel> produtosModel = toCollectionModel(produtosPage.getContent());
		  // Retorna a página paginada de produtos convertidos.
			return new PageImpl<>(produtosModel, produtosPage.getPageable(), produtosPage.getTotalElements());
	}
}
