package com.vertis.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vertis.demo.api.assembler.ProdutoModelAssembler;
import com.vertis.demo.api.model.ProdutoModel;
import com.vertis.demo.api.model.input.ProdutoInput;
import com.vertis.demo.domain.model.Produto;
import com.vertis.demo.domain.service.ProdutoService;

/**
 * Classe controladora para a entidade Produto.
 * Gerencia as requisições HTTP relacionadas aos produtos.
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  
  // Serviço responsável por executar as operações relacionadas aos produtos.
	@Autowired
	private ProdutoService produtoService;

	// Assembler responsável por converter os objetos Produto em objetos ProdutoModel (DTO).
  @Autowired
	private ProdutoModelAssembler produtoModelAssembler;

	/**
	 * Endpoint para listar produtos filtrados com base nos critérios fornecidos.
	 * Realiza uma consulta paginada de produtos com base no objeto ProdutoInput recebido no corpo da requisição.
	 * O objeto ProdutoInput contém os critérios de filtragem.
	 *
	 * @param filtro   Objeto ProdutoInput contendo os critérios de filtragem.
	 * @param pageable Objeto Pageable contendo informações de paginação (página, tamanho, ordenação, etc.).
	 * @return Uma página paginada de ProdutoModel contendo os produtos que correspondem aos critérios de filtragem.
	 */
	@GetMapping("/lista-filtrada")
	public Page<ProdutoModel> listaFiltro(@RequestBody ProdutoInput produtoInput, @PageableDefault(size = 10) Pageable pageable) {
		// Chama o serviço para filtrar os produtos com base nos critérios fornecidos.	
		Page<Produto> produtosPage = produtoService.filtro(produtoInput, pageable);
			
			// Converte a página de produtos em uma página de ProdutoModel (DTO) usando o ProdutoModelAssembler.
			return produtoModelAssembler.toPageModel(produtosPage);
	}
}
