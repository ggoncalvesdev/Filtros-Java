package com.vertis.demo.domain.service.spec;

import org.springframework.data.jpa.domain.Specification;

import com.vertis.demo.api.model.input.ProdutoInput;
import com.vertis.demo.domain.model.Produto;
import com.vertis.demo.domain.service.spec.statics.ProdutoStaticFunctionSpec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * Classe que implementa uma Specification para a entidade Produto.
 * A Specification é utilizada para construir consultas dinâmicas de filtragem
 * com base nos critérios fornecidos através do objeto ProdutoInput.
 */
public class ProdutoSpecification implements Specification<Produto> {

	private static final long serialVersionUID = 1L;

	// Objeto que contém os critérios de filtragem fornecidos pelo usuário.
	private transient ProdutoInput produtoInput;


	/**
	 * Construtor que recebe o objeto ProdutoInput com os critérios de filtragem.
	 *
	 * @param produtoInput Objeto com os critérios de filtragem.
	 */
	public ProdutoSpecification(ProdutoInput produtoInput) {
		this.produtoInput = produtoInput;
	}

	/**
	 * Método que constrói a Specification com base nos critérios fornecidos.
	 * Cria predicados (condições) para cada critério presente no objeto ProdutoInput
	 * e os combina usando a Specification.
	 *
	 * @param root   Root de Produto, usado para acessar os atributos da entidade.
	 * @param query  CriteriaQuery, usada para construir a consulta.
	 * @param builder CriteriaBuilder, usado para criar os predicados.
	 * @return Predicate contendo os predicados combinados.
	 */
	@Override
	public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    // Inicia a Specification com null, para combinarmos os predicados posteriormente.
		Specification<Produto> specification = Specification.where(null);

		// Adiciona predicados (condições) para cada critério presente no ProdutoInput.
		if (produtoInput.getId() != null) {
				specification = specification.and(ProdutoStaticFunctionSpec.porId(produtoInput.getId()));
		}
		if (produtoInput.getNome() != null) {
				specification = specification.and(ProdutoStaticFunctionSpec.porNome(produtoInput.getNome()));
		}
		if (produtoInput.getDescricao() != null) {
				specification = specification.and(ProdutoStaticFunctionSpec.porDescricao(produtoInput.getDescricao()));
		}
		if (produtoInput.getQtdEstoque() != null) {
			specification = specification.and(ProdutoStaticFunctionSpec.porQtdEstoque(produtoInput.getQtdEstoque()));
		}
		if (produtoInput.getDataFabricacao() != null) {
			specification = specification.and(ProdutoStaticFunctionSpec.porDataFabricacao(produtoInput.getDataFabricacao()));
		}
		if (produtoInput.getValor() != null) {
			specification = specification.and(ProdutoStaticFunctionSpec.comPrecoMaiorQue(produtoInput.getValor()));
		}
		if (produtoInput.getCategoria() != null) {
			specification = specification.and(ProdutoStaticFunctionSpec.porCategoria(produtoInput.getCategoria().getNome()));
		}

		// Combina os predicados em um único Predicate para ser usado na consulta final.
    return specification.toPredicate(root, query, builder);
	}
}
