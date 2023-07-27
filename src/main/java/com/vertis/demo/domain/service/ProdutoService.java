package com.vertis.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vertis.demo.api.model.input.ProdutoInput;
import com.vertis.demo.domain.exception.ProdutoNaoEncontradoException;
import com.vertis.demo.domain.model.Produto;
import com.vertis.demo.domain.repository.ProdutoRepository;
import com.vertis.demo.domain.service.spec.ProdutoSpecification;

/**
 * Classe de serviço responsável por realizar operações relacionadas à entidade Produto.
 * Contém métodos para filtrar e manipular produtos.
 */
@Service
public class ProdutoService {

	// Repositório de produtos, usado para acessar e persistir os dados no banco.
  @Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Filtra os produtos com base nos critérios fornecidos pelo objeto ProdutoInput e retorna uma página paginada.
	 *
	 * @param produtoInput   Objeto ProdutoInput contendo os critérios de filtragem.
	 * @param pageable Objeto Pageable contendo informações de paginação (página, tamanho, ordenação, etc.).
	 * @return Uma página paginada de produtos que correspondem aos critérios de filtragem.
	 * @throws ProdutoNaoEncontradoException se não for possível retornar a lista de produtos devido a uma exceção NullPointerException.
	 */
	public Page<Produto> filtro(ProdutoInput produtoInput, Pageable pageable) {
		try {
			  // Cria a especificação com base nos critérios de filtragem do objeto ProdutoInput.
				ProdutoSpecification spec = new ProdutoSpecification(produtoInput);
        
				// Realiza a contagem total de produtos que correspondem à especificação.
				long totalElements = produtoRepository.count(spec);

				// Busca os produtos que correspondem à especificação e retorna a página paginada.
				List<Produto> produtos = produtoRepository.findAll(spec, pageable).getContent();
				return new PageImpl<>(produtos, pageable, totalElements);

		} catch (NullPointerException e) {
			// Caso ocorra uma exceção NullPointerException, lançamos uma ProdutoNaoEncontradoException com a mensagem apropriada.
			throw new ProdutoNaoEncontradoException(String.format("Não foi possível retornar a lista, causa %s", e));
		}
	}
}
